package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.productRetro.ProductEntity;
import com.example.androidhome.ani.signupRetro.Respentity;
import com.example.androidhome.ani.signupRetro.SignupEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SliderInterface {
    @GET("/product/cat/{name}")
    Call<List<ProductEntity> >postLog(@Path("name") String name);

}
