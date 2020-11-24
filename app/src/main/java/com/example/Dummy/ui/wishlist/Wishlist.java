package com.example.Dummy.ui.wishlist;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.grid.GridDividerItemDecoration;
import com.example.Dummy.Cart;
import com.example.Dummy.R;
import com.example.Dummy.adapter.RecyclerViewAdapterWishList;
import com.example.Dummy.items.Products;

import java.util.ArrayList;

public class Wishlist extends Fragment {

    private WishlistViewModel mViewModel;
    private TextView mTextView;
    private ArrayList<Products> ProductsList;
    private RecyclerView productRecyclerView;
    RecyclerViewAdapterWishList mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public static Wishlist newInstance() {
        return new Wishlist();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.wish_list, container, false);





        ProductsList = new ArrayList<>();
        for (int i = 24; i < 28; i++) {
            Products products = new Products();
            products.setName("Dog healthy food , large, " + i + "Inch");
            if (i % 2 == 0)
                products.setImage(R.drawable.dog_food);
            else if (i % 3 == 0)
                products.setImage(R.drawable.dog_food2);
            else
                products.setImage(R.drawable.dog_food3);
            ProductsList.add(products);
        }


        ImageButton cart = view.findViewById(R.id.cart_button);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Cart.class);
                startActivity(intent);
            }
        });


        buildRecyclerView(view);
       return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WishlistViewModel.class);
        // TODO: Use the ViewModel





    }


    public void buildRecyclerView(View view) {
        Drawable horizontalDivider = ContextCompat.getDrawable(this.getContext(), R.drawable.line_divider);
        Drawable verticalDivider = ContextCompat.getDrawable(this.getContext(), R.drawable.line_divider);
        productRecyclerView = view.findViewById(R.id.recyclerView_wishlist);
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.addItemDecoration(new GridDividerItemDecoration(horizontalDivider, verticalDivider, 2));
        mLayoutManager = new GridLayoutManager(this.getContext(), 2, RecyclerView.VERTICAL, false);
        mAdapter = new RecyclerViewAdapterWishList(getActivity(), ProductsList);
        productRecyclerView.setLayoutManager(mLayoutManager);
        productRecyclerView.setAdapter(mAdapter);

    }

}