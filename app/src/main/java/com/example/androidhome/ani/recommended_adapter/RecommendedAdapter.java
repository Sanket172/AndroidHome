package com.example.androidhome.ani.recommended_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhome.R;
import  com.example.androidhome.ani.recommended_model.*;
import  com.example.androidhome.ani.recommended_adapter.*;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    private final List<Recommended_Model> recommendedDataList;
    private final RecommendedDataInterface recommendedDataInterface;

    public RecommendedAdapter(List<Recommended_Model> recommendedDataList, RecommendedDataInterface recommendedDataInterface) {
        this.recommendedDataInterface = recommendedDataInterface;
        this.recommendedDataList = recommendedDataList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Recommended_Model recommended_model=recommendedDataList.get(position);
        holder.productName.setText(recommended_model.getProductName());
        holder.attribute1.setText(recommended_model.getAttribute1());
        holder.attribute2.setText(recommended_model.getAttribute2());
        holder.attribute3.setText(recommended_model.getAttribute5());
        holder.attribute4.setText(recommended_model.getAttribute4());

        Glide.with(holder.itemView)
                .load(recommended_model.getImageUrl())
                .fitCenter()
                .into(holder.productImage);

        holder.rootview.setOnClickListener(view -> {

            recommendedDataInterface.onUserClick(recommended_model, view, holder.getAdapterPosition());

        });
    }

    @Override
    public int getItemCount() {
        return recommendedDataList.size();
    }

    @NonNull
    @Override
    public RecommendedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_recycler, parent, false);
        return new RecommendedAdapter.ViewHolder(view);
    }
    public interface RecommendedDataInterface{
        void onUserClick(Recommended_Model recommended_model, View view,int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView productName;
        private final TextView attribute1;
        private final TextView attribute2;
        private final TextView attribute3;
        private final TextView attribute4;

        private final ImageView productImage;

        private final View rootview;

        public ViewHolder(View view){
            super(view);
            rootview=view;

            productName = view.findViewById(R.id.product_name);
            attribute1 = view.findViewById(R.id.Attribute1);
            attribute2 = view.findViewById(R.id.Attribute2);
            attribute3 = view.findViewById(R.id.Attribute3);
            attribute4 = view.findViewById(R.id.Attribute4);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
}
