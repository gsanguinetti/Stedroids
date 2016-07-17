package com.stedroids.stedroids.samplefragment;

import com.stedroids.framework.usecase.UseCase;
import com.stedroids.framework.viewmodel.AbstractUseCaseViewModel;
import com.stedroids.framework.viewmodel.AbstractViewModel;
import com.stedroids.framework.viewmodel.UseCaseExecutionType;
import com.stedroids.stedroids.databinding.SampleFragmentBinding;

/**
 * Created by gastonsanguinetti on 02/07/16.
 */
public class SampleFragmentViewModel extends AbstractUseCaseViewModel<SampleFragmentBinding, String> {

    String text;

    @Override
    public UseCase<String> getUseCase() {
        return new SampleUseCase();
    }

    @Override
    public UseCaseExecutionType getExecutiontype() {
        return UseCaseExecutionType.ALWAYS;
    }

    @Override
    public void onUseCaseFinished(String response) {
        text = response;
        notifyChange();
    }

    public String getSampleText() {
        return text;
    }

    public String getImageUrl() {
        return "https://image.freepik.com/vector-gratis/logo-de-android_634639.jpg";
    }
}
