package com.stedroids.stedroids.remoteconfigfragment;

import com.stedroids.framework.ui.AbstractViewModelFragment;
import com.stedroids.stedroids.R;
import com.stedroids.stedroids.databinding.RemoteconfigFragmentBinding;

/**
 * Created by gastonsanguinetti on 27/07/16.
 */
public class RemoteConfigFragment extends AbstractViewModelFragment<RemoteconfigFragmentBinding, RemoteConfigViewmodel> {
    @Override
    public int getMainLayoutRes() {
        return R.layout.remoteconfig_fragment;
    }

    @Override
    public Class<RemoteConfigViewmodel> getViewModelClass() {
        return RemoteConfigViewmodel.class;
    }
}
