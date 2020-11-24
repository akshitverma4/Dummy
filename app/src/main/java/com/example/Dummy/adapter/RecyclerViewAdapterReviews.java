package com.example.Dummy.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.ShopNowResult;
import com.example.Dummy.items.Reviews;

import java.util.ArrayList;

public class RecyclerViewAdapterReviews extends RecyclerView.Adapter<RecyclerViewAdapterReviews.ExampleViewHolder> {
    private ArrayList<Reviews> mExampleList;

    private RecyclerViewAdapterReviews.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(RecyclerViewAdapterReviews.OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView ratings;
        public TextView head;
        public TextView body;
        public TextView reviewer;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterReviews.OnItemClickListener listener) {
            super(itemView);
            ratings = itemView.findViewById(R.id.indiv_rating);
            head = itemView.findViewById(R.id.rev_head);
            body = itemView.findViewById(R.id.rev_body);
            reviewer = itemView.findViewById(R.id.reviewer);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ShopNowResult.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

    public RecyclerViewAdapterReviews(ArrayList<Reviews> exampleList) {
        mExampleList = exampleList;

    }
    @Override
    public RecyclerViewAdapterReviews.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_review, parent, false);
        return new RecyclerViewAdapterReviews.ExampleViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapterReviews.ExampleViewHolder holder, int position) {
        Reviews currentItem = mExampleList.get(position);
        holder.ratings.setText(currentItem.getRatings());
        holder.head.setText(currentItem.getReviewHead());
        holder.body.setText(currentItem.getReviewBody());
        holder.reviewer.setText(currentItem.getReviewer());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


}
