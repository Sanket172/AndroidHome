package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidhome.Adapter.RecyclerViewAdapter;
import com.example.androidhome.Adapter.RecyclerViewAdapterProduct;
import com.example.androidhome.Model.Category;
import com.example.androidhome.Model.Product;
import com.example.androidhome.Network.ICategoryAPI;
import com.example.androidhome.Network.IProductAPI;
import com.example.androidhome.NetworkManager.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductListByCategoryActivity extends AppCompatActivity implements RecyclerViewAdapterProduct.UserDataInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_by_category);


        //Retrofit
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IProductAPI iProductAPI = retrofit.create(IProductAPI.class);
        Call<List<Product>> products = iProductAPI.getProducts();

        products.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                Log.d("ABC", "Able to fetch data");
                List<Product> productList = response.body();
                RecyclerView recyclerView = findViewById(R.id.recycle_view_product);
                RecyclerViewAdapterProduct recycleViewAdapter = new RecyclerViewAdapterProduct(productList, (RecyclerViewAdapterProduct.ProductInterface) ProductListByCategoryActivity.this);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProductListByCategoryActivity.this));
                recyclerView.setAdapter(recycleViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(ProductListByCategoryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ABC", "Unable to fetch data");
            }
        });
    }


}