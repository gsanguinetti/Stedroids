package com.stedroids.stedroids.samplefragment;

import com.stedroids.framework.usecase.UseCase;

/**
 * Created by gastonsanguinetti on 03/07/16.
 */
public class SampleUseCase extends UseCase<String> {

    @Override
    protected boolean innerExecute() {
        data = "Hello sample use case";
        return true;
    }

}
