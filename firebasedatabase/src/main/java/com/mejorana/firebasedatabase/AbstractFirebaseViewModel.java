package com.mejorana.firebasedatabase;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stedroids.framework.viewmodel.AbstractViewModel;

public abstract class AbstractFirebaseViewModel<T extends ViewDataBinding> extends AbstractViewModel<T> implements ValueEventListener, ChildEventListener {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    private boolean finished = false;
    private boolean failed = false;

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        finished = true;
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        finished = true;
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        finished = true;
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        finished = true;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        finished = true;
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        finished = failed = true;
    }

    @Override
    public void onResume() {
        super.onResume();

        if(reference == null) {
            finished = failed = false;
            this.reference = this.getReference(this.database);
            if (this.attachChildEventListener()) {
                this.reference.addChildEventListener(this);
            }

            if (this.attachValueEventListener()) {
                this.reference.addValueEventListener(this);
            }

            if (this.attachSingleValueEventListener()) {
                this.reference.addListenerForSingleValueEvent(this);
            }
        }
    }



    public void onViewModelDestroyed() {
        if(this.attachValueEventListener() || this.attachSingleValueEventListener()) {
            this.reference.removeEventListener((ValueEventListener) this);
        }

        if(this.attachChildEventListener()) {
            this.reference.removeEventListener((ChildEventListener) this);
        }

        super.onViewModelDestroyed();
    }

    @NonNull
    protected abstract DatabaseReference getReference(FirebaseDatabase firebaseDatabase);

    @NonNull
    protected abstract boolean attachValueEventListener();

    @NonNull
    protected abstract boolean attachChildEventListener();

    @NonNull
    protected abstract boolean attachSingleValueEventListener();

    public boolean isUseCaseFinished() {
        return finished;
    }

    public boolean isUseCaseFailed() {
        return failed;
    }
}