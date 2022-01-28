package com.example.androidhome.ani.builder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuilderProduct {


    private static Retrofit instance;

    public BuilderProduct() {
    }
    public static Retrofit getInstance(){
        if(instance==null){
            synchronized (BuilderProduct.class){
                if(instance==null){
                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.232:8083/").
                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();

//                    instance=new Retrofit.Builder().baseUrl("http://10.177.1.134:1001/").
//                            addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient()).build();

                }
            }
        }
        return instance;
    }
}

