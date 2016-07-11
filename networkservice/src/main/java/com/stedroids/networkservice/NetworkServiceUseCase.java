package com.stedroids.networkservice;

import android.support.annotation.NonNull;

import com.stedroids.framework.usecase.UseCase;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gastonsanguinetti on 11/07/16.
 */
public abstract class NetworkServiceUseCase<T, V> extends UseCase<T> {

    Retrofit retrofit;
    V service;

    @Override
    protected void onPreExecute() {
        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(getNetworkServiceClass());
    }

    @Override
    protected boolean innerExecute() {
        try {
            Call<T> call = makeCall(service);
            data = call.execute().body();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @NonNull
    public abstract String getBaseUrl();

    @NonNull
    public abstract Class<V> getNetworkServiceClass();

    @NonNull
    public abstract Call<T> makeCall(V service);
}
