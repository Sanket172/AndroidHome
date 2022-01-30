package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhome.R;
import com.example.androidhome.ani.RetrofitInterfaces.CartInterface;
import com.example.androidhome.ani.RetrofitInterfaces.CartInterface;
import com.example.androidhome.ani.builder.BuilderCart;
import com.example.androidhome.ani.builder.BuilderProduct;
import com.example.androidhome.ani.cartRetro.CartProducts;
import com.example.androidhome.ani.cartRetro.CartRecieveEntity;
import com.example.androidhome.ani.cart_model.CartModel;
import com.example.androidhome.ani.cart_recieve_adapter.CartRecieveAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartActivity extends AppCompatActivity implements CartRecieveAdapter.CartDataInterface{

    TextView totalp;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Log.d("ABBBBBBBBBBBBBBBBBBBBBB", "Hello ....... ");


        CartProductApi();


        btn = findViewById(R.id.placeorder);
        btn.setOnClickListener(view -> {

            PlaceOrderApi();

        });


    }

    private void PlaceOrderApi(){


        Retrofit retrofit = BuilderCart.getInstance();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "Default");

        CartInterface cartInterface = retrofit.create(CartInterface.class);
        Call<java.lang.Void> cartInterfaceCall = cartInterface.postLogPlace(email);
        cartInterfaceCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Intent i=new Intent(CartActivity.this,DashboardActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(CartActivity.this, "Failled To place", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void CartProductApi() {

        Retrofit retrofit = BuilderCart.getInstance();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.androidhome", Context.MODE_PRIVATE);
        String email =sharedPreferences.getString("email","Default");

        Call<CartRecieveEntity> productListCall = retrofit.create(CartInterface.class).postLogRecieve(email);


        productListCall.enqueue(new Callback<CartRecieveEntity>() {
            @Override
            public void onResponse(Call<CartRecieveEntity> call, Response<CartRecieveEntity> response) {

                RecyclerView recyclerView = findViewById(R.id.cartrecycler);
                CartRecieveAdapter cartRecieveAdapter = new CartRecieveAdapter(response.body().getCartProductList(),  CartActivity.this, CartActivity.this);
                // Toast.makeText(CartActivity.this,response.body().getUserEmail(), Toast.LENGTH_SHORT).show();
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                recyclerView.setAdapter(cartRecieveAdapter);

                totalp = findViewById(R.id.Totaldisplay1);
                totalp.setText(response.body().getGrandTotal() + " ");

                Toast.makeText(getApplicationContext(), response.body().getCartProductList().get(0).getProductName(), Toast.LENGTH_SHORT).show();
                // Toast.makeText(CartActivity.this,response.body().getUserEmail(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(Product.this, "Everything is correct", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<CartRecieveEntity> call, Throwable t) {
                Toast.makeText(CartActivity.this, "Everything is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onUserClick(CartProducts cartProducts) {

    }
}