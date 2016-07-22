package com.stedroids.framework.model;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public abstract class DomainBase extends BaseModel implements Serializable {

    public static void initModel(Class thisClass) {
        FlowManager.getDatabase(thisClass).getWritableDatabase();
    }

}
