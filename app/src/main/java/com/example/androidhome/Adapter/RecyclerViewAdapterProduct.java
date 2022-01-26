package com.example.androidhome.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhome.Model.Category;
import com.example.androidhome.Model.Merchant;
import com.example.androidhome.Model.Product;
import com.example.androidhome.R;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Random;

public class RecyclerViewAdapterProduct extends RecyclerView.Adapter<RecyclerViewAdapterProduct.ViewHolder>  {


    private final List<Product> mProduct;
    private final ProductInterface mProductInterface;

    public RecyclerViewAdapterProduct(List<Product> mProduct, ProductInterface mProductInterface) {
        this.mProduct = mProduct;
        this.mProductInterface = mProductInterface;
    }


    @NonNull
    @Override
    public RecyclerViewAdapterProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_view, parent, false);
        return new RecyclerViewAdapterProduct.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterProduct.ViewHolder holder, int position) {

        Random random = new Random();
        Product category = mProduct.get(position);

        // All the holder logic which holds in card view
//
//        holder.categoryName.setText(category.getName());
//        holder.rootView.setOnClickListener((view -> mProductInterface.onUserClick(category)));
    }

    public interface ProductInterface {
        void onUserClick(Product product);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface UserDataInterface {
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private Long id;
        private String name;
        private Long categoryId;
        private String image;
        private List<Merchant> merchantList;
        private Long orderCount;
        private String Description;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;

        }
    }
}
