package com.example.androidhome.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidhome.Model.Category;
import com.example.androidhome.R;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private final List<Category> mCategoryList;
    private final CategoryInterface mCategoryInterface;

    public RecyclerViewAdapter(List<Category> mCategory, CategoryInterface mCategoryInterface) {
        this.mCategoryList = mCategory;
        this.mCategoryInterface = mCategoryInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Category category = mCategoryList.get(position);
        holder.rootView.setOnClickListener(view -> {
            notifyDataSetChanged();
           // mCategoryInterface.onClickDelete(mCategoryList,position);
        });

        holder.categoryName.setText(category.getName());
        holder.id.setText(Integer.toString(category.getId().intValue()));

        Category category1 = mCategoryList.get(position);
        holder.id.setText(category1.getId().toString());
        holder.categoryName.setText(category1.getName());

        //Glide.with(holder.ivProfile.getContext()).load(userData.getImageUrl()).placeholder(R.drawable.aaaa).into(holder.ivProfile);
        holder.rootView.setOnClickListener((view -> mCategoryInterface.onUserClick(category)));
    }

    public interface CategoryInterface {
        void onUserClick(Category category);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        //private final ImageView imageView;
        private final TextView categoryName;
        private final TextView id;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            categoryName = view.findViewById(R.id.category_name);
            id = view.findViewById(R.id.Attribute1);


        }
    }
}
