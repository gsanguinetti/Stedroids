package com.stedroids.stedroids.recyclerfragment;

import com.stedroids.framework.ui.AbstractViewModelFragment;
import com.stedroids.stedroids.R;
import com.stedroids.stedroids.databinding.RecyclerFragmentBinding;

/**
 * Created by gastonsanguinetti on 11/07/16.
 */
public class RecyclerFragment extends AbstractViewModelFragment<RecyclerFragmentBinding, RecyclerViewModel> {
    @Override
    public int getMainLayoutRes() {
        return R.layout.recycler_fragment;
    }

    @Override
    public Class<RecyclerViewModel> getViewModelClass() {
        return RecyclerViewModel.class;
    }
}
