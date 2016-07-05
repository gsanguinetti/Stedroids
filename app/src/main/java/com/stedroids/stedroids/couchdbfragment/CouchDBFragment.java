package com.stedroids.stedroids.couchdbfragment;

import com.stedroids.framework.ui.AbstractViewModelFragment;
import com.stedroids.stedroids.R;
import com.stedroids.stedroids.databinding.CouchdbFragmentBinding;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public class CouchDBFragment extends AbstractViewModelFragment<CouchdbFragmentBinding, SampleCouchDbViewModel>{

    @Override
    public int getMainLayoutRes() {
        return R.layout.couchdb_fragment;
    }

    @Override
    public Class<SampleCouchDbViewModel> getViewModelClass() {
        return SampleCouchDbViewModel.class;
    }
}
