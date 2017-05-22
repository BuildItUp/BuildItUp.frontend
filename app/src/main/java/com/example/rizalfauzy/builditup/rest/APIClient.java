package com.example.rizalfauzy.builditup.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class APIClient {
    public static final String BASE_URL = "http://192.168.1.10/yii2/BuildIt/frontend/web/api/";
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
