package com.stedroids.stedroids.recyclerfragment;

import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;
import com.stedroids.lists.AbstractListViewModel;
import com.stedroids.stedroids.R;
import com.stedroids.stedroids.BR;
import com.stedroids.stedroids.couchdbfragment.SampleCouchDBUseCase;
import com.stedroids.stedroids.couchdbfragment.domain.LastEpisode;
import com.stedroids.stedroids.databinding.RecyclerFragmentBinding;

import java.util.List;

/**
 * Created by gastonsanguinetti on 11/07/16.
 */
public class RecyclerViewModel extends AbstractListViewModel<RecyclerFragmentBinding, LastEpisode> {
    @Override
    public int getItemLayoutRes() {
        return R.layout.item_lastepisode;
    }

    @Override
    public int getBindableItem() {
        return BR.item;
    }

    @NonNull
    @Override
    public UseCase<List<LastEpisode>> getUseCase() {
        return new SampleCouchDBUseCase();
    }

    @NonNull
    @Override
    public UseCaseExecutionType getExecutiontype() {
        return  UseCaseExecutionType.ALWAYS;
    }

    @Override
    public void onUseCaseFinished(List<LastEpisode> response) {
        items.addAll(response);
        notifyChange();
    }

    @Override
    public void onUseCaseStarted() {
        items.clear();
        super.onUseCaseStarted();
    }

    public int getLoadingLayout() {
        return R.layout.recycler_loading;
    }
}
