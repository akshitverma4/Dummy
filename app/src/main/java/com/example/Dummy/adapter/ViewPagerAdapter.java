package com.example.Dummy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import com.example.Dummy.R;
import com.example.Dummy.RoundedTransformation;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;private LayoutInflater layoutInflater;
    private String[] imageUrls;
    public ViewPagerAdapter(Context context, String[] imageUrls) {
        this.context = context;
        this.imageUrls = imageUrls;
    }
    @Override
    public int getCount() {
        return imageUrls.length;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);

        Picasso.get()
                .load(imageUrls[position])
                .placeholder(R.drawable.loading_bone)
                .fit()
                .transform( new RoundedTransformation(100,0))
                .centerInside()
                .error(R.drawable.final_logo)
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}