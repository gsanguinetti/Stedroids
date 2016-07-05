package com.stedroids.stedroids.couchdbfragment;

import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.viewmodel.AbstractUseCaseViewModel;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;
import com.stedroids.stedroids.couchdbfragment.domain.LastEpisode;
import com.stedroids.stedroids.databinding.CouchdbFragmentBinding;

import java.util.List;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public class SampleCouchDbViewModel extends AbstractUseCaseViewModel<CouchdbFragmentBinding, List<LastEpisode>> {

    List<LastEpisode> episodes;

    public ObservableField<Drawable> lastEpisodeDrawable = new ObservableField<>();

    @NonNull
    @Override
    public UseCase<List<LastEpisode>> getUseCase() {
        return new SampleCouchDBUseCase();
    }

    @NonNull
    @Override
    public UseCaseExecutionType getExecutiontype() {
        return UseCaseExecutionType.ONCE;
    }

    @Override
    public void onUseCaseFinished(List<LastEpisode> response) {
        episodes = response;
        notifyChange();
        refreshImages();
    }

    public String getEpisodesText() {
        String text = "";
        if(episodes != null) {
            for (LastEpisode last: episodes) {
                text += last.getName() + "\n";
            }
        }
        return text;
    }

    public void refreshImages() {
        if (episodes != null) {
            loadRemoteImage(lastEpisodeDrawable, episodes.get(0).getImg(), getContext());
        }
    }
}
