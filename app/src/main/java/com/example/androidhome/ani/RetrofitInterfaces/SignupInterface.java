package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.accuntRetro.AccountData;
import com.example.androidhome.ani.signupRetro.Respentity;
import com.example.androidhome.ani.signupRetro.SignupEntity;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SignupInterface {

    @POST("/user/signup")
    Call<Respentity> postLog(@Body SignupEntity signupEntity);


    @POST("/user/googlesignin")
    Call<Respentity> postLogGoogle(@Body SignupEntity signupEntity);


    @GET("/user/account/{email}")
    Call<AccountData> postLogGetAcc(@Path("email") String email);
}
