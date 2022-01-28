package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.cartRetro.CartEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface CartInterface {


        @POST("/cart/add")
        Call<Void> postLog(@Body CartEntity cartEntity);
}
