package com.example.androidhome.NetworkManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {


    public RetrofitBuilder() {
    }


    // Create Singleton Instance

    private static Retrofit instance = null;

    public static Retrofit getInstance() {
        if(instance == null) {
            synchronized (RetrofitBuilder.class) {
                if(instance == null) {
                    instance = new Retrofit.Builder().baseUrl("http://10.177.1.134:8080/")
                            .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
                }
            }
        }
        return instance;
    }

}
