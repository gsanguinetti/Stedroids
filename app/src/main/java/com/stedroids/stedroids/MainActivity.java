package com.stedroids.stedroids;

import com.stedroids.framework.ui.AbstractViewModelActivity;
import com.stedroids.stedroids.databinding.ActivityMainBinding;

public class MainActivity extends AbstractViewModelActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int getMainLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }
}
