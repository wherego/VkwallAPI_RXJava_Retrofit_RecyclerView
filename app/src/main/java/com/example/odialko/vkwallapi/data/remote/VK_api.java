package com.example.odialko.vkwallapi.data.remote;

import com.example.odialko.vkwallapi.data.model.VKwall;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Odialko on 31.08.2016.
 */
public interface VK_api {

    String vkUrlApi = "https://api.vk.com/method/";

    @GET("wall.get?domain=pro_misto&count=100&v=5.53")
    Observable<VKwall> getVkwall();

    class Factory {

        private static VK_api service;

        public static VK_api getIstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(vkUrlApi)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                service = retrofit.create(VK_api.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
