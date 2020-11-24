package com.example.Dummy.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.Dialog.CustomDialogClassWishlist;
import com.example.Dummy.ProductDetails;
import com.example.Dummy.R;
import com.example.Dummy.items.Products;

import java.util.List;

public class RecyclerViewAdapterWishList extends RecyclerView.Adapter<RecyclerViewAdapterWishList.ExampleViewHolder> {
    private List<Products> mExampleList;
    private Activity context;
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
        public ImageButton option;
        public TextView originalPrice;
        public ExampleViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.product_details);
            mImageView = itemView.findViewById(R.id.product_image);
            option = itemView.findViewById(R.id.wishlist_button);
            originalPrice = itemView.findViewById(R.id.original_price_wishlist);
            originalPrice.setPaintFlags(originalPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProductDetails.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

    public RecyclerViewAdapterWishList(Activity context, List<Products> exampleList) {
        mExampleList = exampleList;
        this.context =context;
    }
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_wishlist, parent, false);
        return new ExampleViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Products currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getName());
        holder.mImageView.setImageResource(currentItem.getImage());

        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClassWishlist cdd = new CustomDialogClassWishlist(context);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });

    }
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }



}
