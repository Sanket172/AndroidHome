package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.signupRetro.Respentity;
import com.example.androidhome.ani.signupRetro.SignupEntity;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupInterface {

    @POST("/user/signup")
    Call<Respentity> postLog(@Body SignupEntity signupEntity);

}
