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

/**
 * Created by gastonsanguinetti on 26/07/16.
 */
public abstract class AbstractFirebaseViewModel<T extends ViewDataBinding> extends AbstractViewModel<T>
    implements ValueEventListener, ChildEventListener{

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference;

    @NonNull
    protected abstract DatabaseReference getReference(FirebaseDatabase database);

    @NonNull
    protected abstract boolean attachValueEventListener();

    @NonNull
    protected abstract boolean attachChildEventListener();

    @NonNull
    protected abstract boolean attachSingleValueEventListener();

    @Override
    public void onViewModelCreated() {
        super.onViewModelCreated();
        reference = getReference(database);
        if(attachChildEventListener())
            reference.addChildEventListener(this);
        if(attachValueEventListener())
            reference.addValueEventListener(this);
        if(attachSingleValueEventListener())
            reference.addListenerForSingleValueEvent(this);
    }

    @Override
    public void onViewModelDestroyed() {
        if(attachValueEventListener() || attachSingleValueEventListener()) {
            reference.removeEventListener((ValueEventListener)this);
        }
        if(attachChildEventListener()) {
            reference.removeEventListener((ChildEventListener)this);
        }
        super.onViewModelDestroyed();
    }

    @Override
    public void onViewDetached(boolean finalDetachment) {
        super.onViewDetached(finalDetachment);
    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        //
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        //
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        //
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        //
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        //
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        //
    }
}
