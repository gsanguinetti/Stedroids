package com.stedroids.stedroids.couchdbfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stedroids.framework.ui.blocks.AbstractFragmentDrivenActivity;

public class CouchDBActivity extends AbstractFragmentDrivenActivity {
    @Override
    protected Fragment buildContentFragment(Bundle args) {
        return CouchDBFragment.instantiate(this, CouchDBFragment.class.getCanonicalName(), getfragmentArgs());
    }

    @Override
    protected Bundle getfragmentArgs() {
        return new Bundle();
    }
}
