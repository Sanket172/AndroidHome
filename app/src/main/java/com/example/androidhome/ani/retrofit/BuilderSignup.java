package com.example.androidhome.ani.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuilderSignup {

    private static Retrofit instance;
    public BuilderSignup() {
    }
    public static Retrofit getInstance(){
        if(instance==null){
            synchronized (BuilderLogin.class){
                if(instance==null){
                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.145:1000/user").
                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();
                }
            }
        }
        return instance;
    }
}