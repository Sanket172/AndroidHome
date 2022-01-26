package com.example.androidhome.ani.repository;

import android.service.autofill.UserData;

import com.example.androidhome.ani.product_model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductAPI {


     //  @GET({cname})
    //Call<List<ProductModel>> getProductByCategory(@Path("cname") String cname);
//     @GET("product")
//    Call<List<ProductModel>> getProductByCategory();


    @GET("posts")
    Call<List<UserData>> getPosts();

}
