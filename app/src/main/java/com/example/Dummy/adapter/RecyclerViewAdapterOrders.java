package com.example.Dummy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.OrderDetails;
import com.example.Dummy.R;
import com.example.Dummy.WriteReview;
import com.example.Dummy.items.OrdersItem;

import java.util.ArrayList;


public class RecyclerViewAdapterOrders extends RecyclerView.Adapter<RecyclerViewAdapterOrders.ExampleViewHolder> {
    private final ArrayList<OrdersItem> mExampleList;
    private Context mContext;
    private Activity mActivity;

    private RecyclerViewAdapterOrders.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView status;
        public ImageView imageView;
        public TextView rating;

        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterOrders.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.order_product_name);
                status = itemView.findViewById(R.id.order_status);
                imageView = itemView.findViewById(R.id.order_product_image);
                rating = itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), OrderDetails.class);
                    itemView.getContext().startActivity(intent);


                }
            });


        }
    }

    public RecyclerViewAdapterOrders(ArrayList<OrdersItem> exampleList, Context context, Activity activity) {
        mExampleList = exampleList;
        this.mContext = context;
        this.mActivity = activity;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_orders, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        OrdersItem currentItem = mExampleList.get(position);
        holder.name.setText(currentItem.getName());
        holder.status.setText("Delivered on 17 Oct");
        holder.imageView.setImageResource(R.drawable.dog_food2);
        holder.rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WriteReview.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}