package com.example.androidhome.ani.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static Retrofit instance;

    private RetrofitBuilder(){};

    public static Retrofit getInstance()
    {
        if(instance == null)
        {
            synchronized (com.example.androidhome.ani.retrofit.RetrofitBuilder.class)
            {
                if(instance == null)
                {
                //    instance = new Retrofit.Builder().baseUrl("http://10.177.1.134:8080/").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
                    instance = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
                }
            }
        }

        return instance;
    }
}
