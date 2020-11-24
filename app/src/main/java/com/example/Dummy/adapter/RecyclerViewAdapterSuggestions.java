package com.example.Dummy.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

import com.example.Dummy.R;
import com.example.Dummy.ShopNowResult;
import com.example.Dummy.items.Suggestions;
import com.example.Dummy.ui.book_service.BookServiceViewAll;

public class RecyclerViewAdapterSuggestions extends RecyclerView.Adapter<RecyclerViewAdapterSuggestions.ExampleViewHolder> {
    private ArrayList<Suggestions> mExampleList;


    private RecyclerViewAdapterSuggestions.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(RecyclerViewAdapterSuggestions.OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public ImageView mImageView;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterSuggestions.OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.suggestion);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("search", "onClick: "+itemView.getContext());
                    if(itemView.getContext().toString().contains("SearchViewProviders"))
                        itemView.getContext().startActivity(new Intent(itemView.getContext(), BookServiceViewAll.class));
                    else
                    itemView.getContext().startActivity(new Intent(itemView.getContext(), ShopNowResult.class));
                }
            });


        }
    }

    public RecyclerViewAdapterSuggestions(ArrayList<Suggestions> exampleList) {
        mExampleList = exampleList;

    }
    @Override
    public RecyclerViewAdapterSuggestions.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_suggestion, parent, false);
        return new RecyclerViewAdapterSuggestions.ExampleViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdapterSuggestions.ExampleViewHolder holder, int position) {
        Suggestions currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getSuggestion());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public void filterList(ArrayList<Suggestions> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }


}
