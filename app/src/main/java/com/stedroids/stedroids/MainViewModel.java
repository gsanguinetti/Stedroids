package com.stedroids.stedroids;

import android.content.Intent;
import android.view.View;

import com.stedroids.framework.crash.FirebaseCrashReporter;
import com.stedroids.framework.viewmodel.AbstractViewModel;
import com.stedroids.stedroids.analytics.SampleAnalyticsSender;
import com.stedroids.stedroids.couchdbfragment.CouchDBActivity;
import com.stedroids.stedroids.databinding.ActivityMainBinding;

import com.stedroids.stedroids.global.SampleApp;
import com.stedroids.stedroids.recyclerfragment.RecyclerActivity;
import com.stedroids.stedroids.samplefragment.SampleFragmentActivity;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public class MainViewModel extends AbstractViewModel<ActivityMainBinding> {

    public void onNewSampleFragmentButtonClick(View v) {
        getContext().startActivity(new Intent(getContext(), SampleFragmentActivity.class));
    }

    public void onNewCouchdbFragmentButtonClick(View v) {
        getAbstractApplication().getCrashReporter(FirebaseCrashReporter.class.getCanonicalName())
                .reportHandledException(new Exception("test exception"));
        getContext().startActivity(new Intent(getContext(), CouchDBActivity.class));
    }

    public void onNewRecyclerFragmentButtonClick(View v) {
        getContext().startActivity(new Intent(getContext(), RecyclerActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((SampleApp)getAbstractApplication()).getAnalyticsSender().trackAppMenuOpened();
    }
}
