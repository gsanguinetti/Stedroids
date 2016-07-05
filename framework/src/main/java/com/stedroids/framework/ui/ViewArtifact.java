package com.stedroids.framework.ui;

import com.stedroids.framework.viewmodel.AbstractViewModel;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public interface ViewArtifact<S extends AbstractViewModel> {
    int getMainLayoutRes();
    Class<S> getViewModelClass();
}
