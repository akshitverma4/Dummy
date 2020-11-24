package com.example.Dummy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.EditPet;
import com.example.Dummy.R;
import com.example.Dummy.items.MyPetsItem;


import java.util.ArrayList;


public class RecyclerViewAdapterMyPets extends RecyclerView.Adapter<RecyclerViewAdapterMyPets.ExampleViewHolder> {
    private final ArrayList<MyPetsItem> mExampleList;
    private Context mContext;

    private RecyclerViewAdapterMyPets.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onProductClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_my_pets, parent, false);
        return new ExampleViewHolder(v, mListener);
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView remove_pet;
        public TextView pet_type;

        public ExampleViewHolder(final View itemView, final RecyclerViewAdapterMyPets.OnItemClickListener listener) {
            super(itemView);
                name = itemView.findViewById(R.id.row_pet_name);
                pet_type = itemView.findViewById(R.id.row_pet_type);
                remove_pet = itemView.findViewById(R.id.remove_pet);

                remove_pet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), EditPet.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

    public RecyclerViewAdapterMyPets(ArrayList<MyPetsItem> exampleList, Context context) {
        mExampleList = exampleList;
        this.mContext = context;

    }


    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        MyPetsItem currentItem = mExampleList.get(position);
        holder.name.setText(currentItem.getPetName());
        holder.pet_type.setText(currentItem.getPetType());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}