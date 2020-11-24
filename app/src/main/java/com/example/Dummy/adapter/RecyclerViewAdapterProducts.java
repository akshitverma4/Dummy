package com.example.Dummy.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import com.example.Dummy.ProductDetails;
import com.example.Dummy.R;
import com.example.Dummy.items.Products;

public class RecyclerViewAdapterProducts extends RecyclerView.Adapter<RecyclerViewAdapterProducts.ExampleViewHolder> implements Filterable{
    private List<Products> mExampleList;
    private List<Products> mExampleListFull;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onProductClick(int position);
        void onDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public ImageView mImageView;
        public ImageButton like;
        public Boolean isLike =false;

        public ExampleViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.product_details);
            mImageView = itemView.findViewById(R.id.product_image);
            like = itemView.findViewById(R.id.like_button);
            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isLike) {
                        like.setColorFilter(Color.LTGRAY);
                        isLike = false;
                    }
                    else {
                        like.setColorFilter(Color.RED);
                        isLike = true;
                        Toast.makeText(view.getContext(),"Added to Favourites",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetails.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

    public RecyclerViewAdapterProducts(List<Products> exampleList) {
        mExampleList = exampleList;
        mExampleListFull = new ArrayList<>(exampleList);
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid_shop_now, parent, false);
        return new ExampleViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Products currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getName());
        holder.mImageView.setImageResource(currentItem.getImage());

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private final Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
             List<Products> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mExampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Products item : mExampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mExampleList.clear();
            mExampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

}
