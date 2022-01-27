package com.example.androidhome.ani.recommended_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhome.R;

import com.example.androidhome.ani.recommendRetro.RecommendEntity;
import  com.example.androidhome.ani.recommended_adapter.*;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {

    private final List<RecommendEntity> recommendedDataList;
    private final RecommendedDataInterface recommendedDataInterface;

    public RecommendedAdapter(List<RecommendEntity> recommendedDataList, RecommendedDataInterface recommendedDataInterface) {
        this.recommendedDataInterface = recommendedDataInterface;
        this.recommendedDataList = recommendedDataList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RecommendEntity recommendEntity=recommendedDataList.get(position);
        holder.productName.setText(recommendEntity.getProductName());
        holder.attribute1.setText(recommendEntity.getAttribute1());
        holder.attribute2.setText(recommendEntity.getAttribute2());
        holder.attribute3.setText(recommendEntity.getAttribute5());
        holder.attribute4.setText(recommendEntity.getAttribute4());

        Glide.with(holder.itemView)
                .load(recommendEntity.getImage())
                .fitCenter()
                .into(holder.productImage);

        holder.rootview.setOnClickListener(view -> {
            recommendedDataInterface.onUserClick(recommendEntity, view, holder.getAdapterPosition());
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
        void onUserClick(RecommendEntity recommendEntity, View view,int position);
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
            attribute1 = view.findViewById(R.id.Attribute10);
            attribute2 = view.findViewById(R.id.Attribute20);
            attribute3 = view.findViewById(R.id.Attribute30);
            attribute4 = view.findViewById(R.id.Attribute40);
            productImage = itemView.findViewById(R.id.product_image10);
        }
    }
}
