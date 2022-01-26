package com.example.androidhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidhome.Adapter.RecyclerViewAdapter;
import com.example.androidhome.Model.Category;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends AppCompatActivity implements RecyclerViewAdapter.CategoryInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        List<Category> categoryList = new ArrayList<>();
        generateUserData(categoryList);

        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(categoryList, RecyclerView.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onUserClick(Category categoryData) {
        Toast.makeText(this, "Image Clicked for" + categoryData.getName(), Toast.LENGTH_SHORT).show();
    }

    private void generateUserData(List<Category> categoryList) {

        for(int i=0;i<15;i++) {
            categoryList.add(new Category(BigInteger.valueOf(10), "Category 1", "https://fortmyersradon.com/wp-content/uploads/2019/12/dummy-user-img-1.png"));
        }
    }
}
