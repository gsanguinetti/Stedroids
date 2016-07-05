package com.stedroids.couchdb;

import android.util.Log;

import com.stedroids.framework.usecase.UseCase;

import org.lightcouch.CouchDbClientAndroid;
import org.lightcouch.CouchDbProperties;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public abstract class CouchDbUseCase<T> extends UseCase<T> {

    private static final String LOG_TAG = "CouchDb";

    CouchDbClientAndroid client;

    @Override
    protected boolean innerExecute() {
        try {
            client = new CouchDbClientAndroid(getDBProperties());
            Log.d(LOG_TAG, client.getDBUri().toString());
            data = execDBOperation(client);
        } catch (Exception ex) {
            return false;
        }
        client.shutdown();
        return true;
    }

    protected abstract CouchDbProperties getDBProperties();
    protected abstract T execDBOperation(CouchDbClientAndroid client);
}
