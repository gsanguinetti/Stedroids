package com.stedroids.framework.ui.blocks;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.stedroids.framework.R;
import com.stedroids.framework.ui.AbstractActivity;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public abstract class AbstractFragmentDrivenActivity extends AbstractActivity {

    private static final String CONTENT_FRAGMENT_TAG = "contentFragment";

    private Fragment fragment;

    @Override
    protected void onAfterSetContentView(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            fragment = buildContentFragment(getfragmentArgs());
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, fragment, CONTENT_FRAGMENT_TAG)
                    .commit();
        } else {
            fragment = getSupportFragmentManager().findFragmentByTag(CONTENT_FRAGMENT_TAG);
        }
    }

    @Override
    protected int getContentRes() {
        return R.layout.activity_fragment_driven;
    }

    public Fragment getContentFragment(){
        return fragment;
    }

    protected abstract Fragment buildContentFragment(Bundle args);
    protected abstract Bundle getfragmentArgs();
}
