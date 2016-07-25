package com.stedroids.stedroids.global;

import com.stedroids.framework.analytics.BaseAnalyticsSender;
import com.stedroids.framework.analytics.Firebase.FirebaseAnalyticsTracker;
import com.stedroids.framework.global.AbstractApplication;
import com.stedroids.imageloader.picasso.PicassoPlugableGlobalComponent;
import com.stedroids.stedroids.analytics.SampleAnalyticsSender;
import com.stedroids.stedroids.analytics.SampleFirebaseTracker;
import com.stedroids.stedroids.analytics.SampleTracker;

/**
 * Created by gastonsanguinetti on 05/07/16.
 */
public class SampleApp extends AbstractApplication<SampleAnalyticsSender> {

    @Override
    public void onCreate() {
        super.onCreate();

        this.plugComponent(new PicassoPlugableGlobalComponent());
    }

    @Override
    public SampleAnalyticsSender startAnalyticsTrackers() {

        SampleFirebaseTracker sampleFirebaseTracker = new SampleFirebaseTracker(
                new FirebaseAnalyticsTracker(this), true);

        return new SampleAnalyticsSender(this, sampleFirebaseTracker);
    }
}
