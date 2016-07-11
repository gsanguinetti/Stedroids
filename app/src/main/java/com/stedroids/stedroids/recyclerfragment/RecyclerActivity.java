package com.stedroids.stedroids.recyclerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.stedroids.framework.ui.blocks.AbstractFragmentDrivenActivity;

/**
 * Created by gastonsanguinetti on 06/07/16.
 */
public class RecyclerActivity extends AbstractFragmentDrivenActivity {

    @Override
    protected Fragment buildContentFragment(Bundle args) {
        return RecyclerFragment.instantiate(this, RecyclerFragment.class.getCanonicalName(), getfragmentArgs());
    }

    @Override
    protected Bundle getfragmentArgs() {
        return new Bundle();
    }
}
