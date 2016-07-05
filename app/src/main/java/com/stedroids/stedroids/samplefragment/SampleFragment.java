package com.stedroids.stedroids.samplefragment;

import com.stedroids.framework.ui.AbstractViewModelFragment;
import com.stedroids.stedroids.R;
import com.stedroids.stedroids.databinding.SampleFragmentBinding;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public class SampleFragment extends AbstractViewModelFragment<SampleFragmentBinding, SampleFragmentViewModel> {

    @Override
    public int getMainLayoutRes() {
        return R.layout.sample_fragment;
    }

    @Override
    public Class<SampleFragmentViewModel> getViewModelClass() {
        return SampleFragmentViewModel.class;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
