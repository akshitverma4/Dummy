package com.example.Dummy.adapter;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.Dummy.R;
import com.example.Dummy.ShopNowResult;
import com.example.Dummy.items.CartItem;


public class RecyclerViewAdapterCart extends RecyclerView.Adapter<RecyclerViewAdapterCart.ExampleViewHolder> {
    private final ArrayList<CartItem> mExampleList;


    private RecyclerViewAdapterCart.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView1;
        public ImageView imageView;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterCart.OnItemClickListener listener) {
            super(itemView);
                mTextView1 = itemView.findViewById(R.id.cart_product_name);
                imageView = itemView.findViewById(R.id.cart_product_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ShopNowResult.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

    public RecyclerViewAdapterCart(ArrayList<CartItem> exampleList) {
        mExampleList = exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cart, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        CartItem currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getName());
        holder.imageView.setImageResource(R.drawable.dog_food2);

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}