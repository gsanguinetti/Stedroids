package com.stedroids.stedroids.couchdbfragment;

import com.stedroids.couchdb.CouchDbUseCase;
import com.stedroids.stedroids.couchdbfragment.domain.LastEpisode;

import org.lightcouch.CouchDbClientAndroid;
import org.lightcouch.CouchDbProperties;

import java.util.List;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public class SampleCouchDBUseCase extends CouchDbUseCase<List<LastEpisode>> {

    @Override
    protected CouchDbProperties getDBProperties() {
        return new CouchDbProperties("sitemap-data-anime_flv_last_series",
                false, "http", "104.155.73.101" , 5984, "admin", "cCx5pnv0" );
    }

    @Override
    protected List<LastEpisode> execDBOperation(CouchDbClientAndroid client) {
        return client.view("lasts/all")
                .includeDocs(true)
                .query(LastEpisode.class);
    }
}
