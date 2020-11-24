package com.example.Dummy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.items.ProvidersFeedback;
import com.example.Dummy.ui.book_service.ProviderDetails;

import java.util.ArrayList;


public class RecyclerViewAdapterProvidersFeedback extends RecyclerView.Adapter<RecyclerViewAdapterProvidersFeedback.ExampleViewHolder> {
    private final ArrayList<ProvidersFeedback> mExampleList;
    private Context mContext;

    private RecyclerViewAdapterProvidersFeedback.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_provider_feedback, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView feed;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterProvidersFeedback.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.feedback_name);
                feed = itemView.findViewById(R.id.feedback);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProviderDetails.class);
                  // itemView.getContext().startActivity(intent);


                }
            });


        }
    }

    public RecyclerViewAdapterProvidersFeedback(ArrayList<ProvidersFeedback> exampleList, Context context) {
        mExampleList = exampleList;
        this.mContext = context;

    }


    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        ProvidersFeedback currentItem = mExampleList.get(position);
        holder.name.setText(currentItem.getName());
        holder.feed.setText(currentItem.getFeedback());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}