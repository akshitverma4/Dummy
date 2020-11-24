package com.example.Dummy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import com.example.Dummy.R;
import com.example.Dummy.items.SliderItem;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

   private List<SliderItem> sliderItems;
   private ViewPager2 viewPager2;

    public SliderAdapter(List<SliderItem> sliderItems, ViewPager2 viewPager2){
       this.sliderItems =sliderItems;
       this.viewPager2 =viewPager2;
   }
    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_item_container,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;
        SliderViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
           // imageView.setPadding(0,200,0,200);
        }
        void setImage(SliderItem sliderItem){
            imageView.setImageResource(sliderItem.getImage());
        }

    }
}
