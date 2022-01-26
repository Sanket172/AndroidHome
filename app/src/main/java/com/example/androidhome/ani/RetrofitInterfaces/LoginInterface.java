package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.loginRetro.LoginEntity;
import com.example.androidhome.ani.signupRetro.Respentity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginInterface {

    @POST("/user/signin")
    Call<Respentity> postLog(@Body LoginEntity loginEntity);

}