package com.example.Dummy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.items.ServiceProviders;
import com.example.Dummy.ui.book_service.BookForm1;
import com.example.Dummy.ui.book_service.ProviderDetails;
import com.example.Dummy.ui.chat_with_experts.AppointmentForm;

import java.util.ArrayList;


public class RecyclerViewAdapterViewAllProviders extends RecyclerView.Adapter<RecyclerViewAdapterViewAllProviders.ExampleViewHolder> {
    private final ArrayList<ServiceProviders> mExampleList;
    private Context mContext;
    private Integer id;
    private RecyclerViewAdapterViewAllProviders.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_all_providers_service, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageButton details;
        public Button book;
        public Integer id;
        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterViewAllProviders.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.name_book);
                details = itemView.findViewById(R.id.to_provider_details);

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ProviderDetails.class);
                        itemView.getContext().startActivity(intent);

                    }
                });

            book = itemView.findViewById(R.id.book);

            book.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(id==1) {
                        Intent intent = new Intent(itemView.getContext(), AppointmentForm.class);
                        intent.putExtra("id",1);
                        itemView.getContext().startActivity(intent);
                    }
                    else
                       itemView.getContext().startActivity(new Intent(itemView.getContext(), BookForm1.class));
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


        }
    }

    public RecyclerViewAdapterViewAllProviders(ArrayList<ServiceProviders> exampleList, Context context, Integer id) {
        mExampleList = exampleList;
        this.mContext = context;
        this.id = id;
    }


    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        ServiceProviders currentItem = mExampleList.get(position);
        holder.name.setText(currentItem.getName());
        holder.id = this.id;

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}