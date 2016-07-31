package com.stedroids.stedroids.remoteconfigfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.stedroids.framework.ui.blocks.AbstractFragmentDrivenActivity;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public class RemoteConfigActivity extends AbstractFragmentDrivenActivity {
    @Override
    protected Fragment buildContentFragment(Bundle args) {
        return RemoteConfigFragment.instantiate(this, RemoteConfigFragment.class.getCanonicalName(), getfragmentArgs());
    }

    @Override
    protected Bundle getfragmentArgs() {
        return new Bundle();
    }
}
