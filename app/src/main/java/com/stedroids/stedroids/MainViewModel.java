package com.stedroids.stedroids;

import android.content.Intent;
import android.view.View;

import com.stedroids.framework.viewmodel.AbstractViewModel;
import com.stedroids.stedroids.couchdbfragment.CouchDBActivity;
import com.stedroids.stedroids.databinding.ActivityMainBinding;
import com.stedroids.stedroids.samplefragment.SampleFragmentActivity;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public class MainViewModel extends AbstractViewModel<ActivityMainBinding> {

    public void onNewSampleFragmentButtonClick(View v) {
        getContext().startActivity(new Intent(getContext(), SampleFragmentActivity.class));
    }

    public void onNewCouchdbFragmentButtonClick(View v) {
        getContext().startActivity(new Intent(getContext(), CouchDBActivity.class));
    }
}
