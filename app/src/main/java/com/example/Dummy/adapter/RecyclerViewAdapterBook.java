package com.example.Dummy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.items.ServiceProviders;
import com.example.Dummy.ui.book_service.BookForm1;
import com.example.Dummy.ui.book_service.ProviderDetails;

import java.util.ArrayList;


public class RecyclerViewAdapterBook extends RecyclerView.Adapter<RecyclerViewAdapterBook.ExampleViewHolder> {
    private final ArrayList<ServiceProviders> mExampleList;
    private Context mContext;
    private Activity mActivity;

    private RecyclerViewAdapterBook.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_book_service, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public Button book;


        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterBook.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.name_book);
                book = itemView.findViewById(R.id.book);

                book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), BookForm1.class);
                        itemView.getContext().startActivity(intent);
                    }
                });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ProviderDetails.class);
                    itemView.getContext().startActivity(intent);


                }
            });


        }
    }

    public RecyclerViewAdapterBook(ArrayList<ServiceProviders> exampleList, Context context, Activity activity) {
        mExampleList = exampleList;
        this.mContext = context;
        this.mActivity = activity;
    }


    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        ServiceProviders currentItem = mExampleList.get(position);
        holder.name.setText(currentItem.getName());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}