package com.stedroids.lists;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.viewmodel.AbstractUseCaseViewModel;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;

import java.util.List;

import me.tatarka.bindingcollectionadapter.ItemView;

/**
 * Created by gastonsanguinetti on 11/07/16.
 */
public abstract class AbstractListViewModel<V extends ViewDataBinding, T> extends AbstractUseCaseViewModel<V, List<T>> {

    public final ObservableList<T> items = new ObservableArrayList<>();
    public final ItemView itemView = ItemView.of(getBindableItem(), getItemLayoutRes());

    public abstract int getItemLayoutRes();
    public abstract int getBindableItem();
}
