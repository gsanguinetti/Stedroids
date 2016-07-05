package com.stedroids.stedroids.samplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.stedroids.framework.ui.blocks.AbstractFragmentDrivenActivity;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public class SampleFragmentActivity extends AbstractFragmentDrivenActivity {

    @Override
    protected Fragment buildContentFragment(Bundle args) {
        return SampleFragment.instantiate(this, SampleFragment.class.getCanonicalName(), args);
    }

    @Override
    protected Bundle getfragmentArgs() {
        return new Bundle();
    }
}
