package com.example.Dummy.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.ShopNowResult;
import com.example.Dummy.items.ReviewPics;

import java.util.ArrayList;

public class RecyclerViewAdapterReviewPics extends RecyclerView.Adapter<RecyclerViewAdapterReviewPics.ExampleViewHolder> {
    private ArrayList<ReviewPics> mExampleList;

    private RecyclerViewAdapterReviewPics.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(RecyclerViewAdapterReviewPics.OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterReviewPics.OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.review_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ShopNowResult.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

    public RecyclerViewAdapterReviewPics(ArrayList<ReviewPics> exampleList) {
        mExampleList = exampleList;

    }
    @Override
    public RecyclerViewAdapterReviewPics.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_review_pics, parent, false);
        return new RecyclerViewAdapterReviewPics.ExampleViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapterReviewPics.ExampleViewHolder holder, int position) {
        ReviewPics currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImage());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
