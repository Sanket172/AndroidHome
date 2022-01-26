package com.example.androidhome.Network;

import com.example.androidhome.Model.Category;
import com.example.androidhome.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IProductAPI {

    @GET("product")
    Call<List<Product>> getProducts();
}
