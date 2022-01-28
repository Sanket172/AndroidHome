package com.example.androidhome.ani.builder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuilderSignup {

    private static Retrofit instance;

    public BuilderSignup() {
    }
    public static Retrofit getInstance(){
        if(instance==null){
            synchronized (BuilderSignup.class){
                if(instance==null){
                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.232:1000/").
                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();

//                   instance=new Retrofit.Builder().baseUrl("http://10.177.1.134:1000/").
//                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
                }
            }
        }
        return instance;
    }
}
