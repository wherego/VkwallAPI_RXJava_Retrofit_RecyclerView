package com.example.odialko.vkwallapi.data.remote;

import com.example.odialko.vkwallapi.data.model.VKwall;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Odialko on 31.08.2016.
 */
public interface VK_api {

    String vkUrlApi = "https://api.vk.com/method/";

    @GET("wall.get?domain=pro_misto&count=10&v=5.53")
    Call<VKwall> getVkwall();

    class Factory {

        private static VK_api service;

        public static VK_api getIstance() {

            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(vkUrlApi).build();
                service = retrofit.create(VK_api.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
