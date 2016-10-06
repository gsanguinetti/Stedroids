package com.stedroids.framework.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public abstract class AbstractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        onBeforeSetContentView();
        super.onCreate(savedInstanceState);
        setContentView(getContentRes());
        onAfterSetContentView(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void onBeforeSetContentView() {
        //Do nothing
    }

    protected abstract void onAfterSetContentView(Bundle savedInstanceState);

    protected abstract int getContentRes();
}
