package com.example.androidhome.Network;

import com.example.androidhome.Model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ICategoryAPI {


    @GET("category")
    Call<List<Category>> getCategories();

}
