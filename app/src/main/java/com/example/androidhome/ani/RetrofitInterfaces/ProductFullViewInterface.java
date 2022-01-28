package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.productRetro.ProductEntity;
import com.example.androidhome.ani.signupRetro.Respentity;
import com.example.androidhome.ani.signupRetro.SignupEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProductFullViewInterface {
    @GET("/product/{id}")
    Call<ProductEntity> postLog(@Path("id") String  id);
}
