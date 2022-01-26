package com.example.androidhome.ani.slider_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidhome.R;
import com.example.androidhome.ani.recommended_model.Recommended_Model;
import com.smarteist.autoimageslider.SliderViewAdapter;

import com.example.androidhome.ani.slider_model.*;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    private final List<SliderModel> mSliderItems;
    SliderAdapter.OnItemClickListener mListener;
    public SliderAdapter(Context context, List<SliderModel> mSliderItems) {
        this.mSliderItems = mSliderItems;
    }


    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterViewHolder viewHolder, final int position) {

        final SliderModel sliderItem = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
                .load(sliderItem.getImgUrl())
                .fitCenter()
                .into(viewHolder.imageViewBackground);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null) {
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }

            }
        });
    }


    public interface OnItemClickListener {
        void onItemClick(int position);}

    // lets create the set onclick method
    public void setOnItemClickListener(SliderAdapter.OnItemClickListener listener) {
        mListener = listener; }

    @Override
    public int getCount() {
       return mSliderItems.size();
    }


    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        private final View itemView;
        private final ImageView imageViewBackground;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.myimage);
            this.itemView = itemView;
        }
    }
}
