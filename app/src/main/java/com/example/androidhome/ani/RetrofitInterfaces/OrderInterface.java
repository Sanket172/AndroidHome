package com.example.androidhome.ani.RetrofitInterfaces;

import com.example.androidhome.ani.orderhistoryRetro.OrderHistoryEntity;
import com.example.androidhome.ani.orderhistoryRetro.OrderItemsEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface OrderInterface {

    @GET("/order/get/{mail}")
    Call<OrderHistoryEntity> postLogRecieve(@Path("mail") String mail);

    @GET("/order/get")
    Call<OrderItemsEntity> postLogRecieveProductList(@Body OrderItemsEntity orderItemsEntity);

}
