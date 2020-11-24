package com.example.Dummy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.grid.GridDividerItemDecoration;


import java.util.ArrayList;

import com.example.Dummy.Dialog.CustomDialogClassSorting;
import com.example.Dummy.adapter.RecyclerViewAdapterProducts;
import com.example.Dummy.items.Products;

public class ShopNowMain extends AppCompatActivity {

    private TextView mTextView;
    private ArrayList<Products> ProductsList;
    private RecyclerView productRecyclerView;
    private ImageButton back;
    RecyclerViewAdapterProducts mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_now_main);

        TextView search = findViewById(R.id.searchViewMain);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopNowMain.this, SearchViewShop.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.back_shop_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ProductsList = new ArrayList<>();
        for (int i = 24; i < 34; i++) {
            Products products = new Products();
            products.setName("Dog healthy food , large, " + i + "Inch ddfsg s fdg df  dff gsfgsdfg   dfgsg");
            if (i % 2 == 0)
                products.setImage(R.drawable.dog_food);
            else if (i % 3 == 0)
                products.setImage(R.drawable.dog_food2);
            else
                products.setImage(R.drawable.dog_food3);
            ProductsList.add(products);
        }


        ImageButton cart = findViewById(R.id.cart_main);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ShopNowMain.this, Cart.class);
                startActivity(intent);
            }
        });

        LinearLayout sortBtn = findViewById(R.id.sort_btn_main);
        sortBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialogClassSorting cdd = new CustomDialogClassSorting(ShopNowMain.this);
                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cdd.show();
            }
        });


        LinearLayout filterBtn = findViewById(R.id.filter_btn_main);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShopNowMain.this, Filters.class));
            }
        });

        //Set up Filters
        //initiateFilters();

        buildRecyclerView();


    }


    public void buildRecyclerView() {
        Drawable horizontalDivider = ContextCompat.getDrawable(this, R.drawable.line_divider);
        Drawable verticalDivider = ContextCompat.getDrawable(this, R.drawable.line_divider);
        productRecyclerView = findViewById(R.id.recyclerView_shop_now_main);
        productRecyclerView.setHasFixedSize(true);
        productRecyclerView.addItemDecoration(new GridDividerItemDecoration(horizontalDivider, verticalDivider, 2));
        mLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        mAdapter = new RecyclerViewAdapterProducts(ProductsList);
        productRecyclerView.setLayoutManager(mLayoutManager);
        productRecyclerView.setAdapter(mAdapter);

    }

//    public void initiateFilters(){
//        final Button button_pet = findViewById(R.id.button_pet);
//        Button button_food = findViewById(R.id.button_food);
//        Button button_accessories = findViewById(R.id.button_accessories);
//        Button button_grooming = findViewById(R.id.button_grooming);
//
//        button_pet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                button_pet.setBackgroundColor(getResources().getColor(R.color.theme_color));
//                CustomDialogClassPet cdd = new CustomDialogClassPet(ShopNowMain.this);
//                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                cdd.show();
//
//            }
//        });
//
//        button_food.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CustomDialogClassFood cdd = new CustomDialogClassFood(ShopNowMain.this);
//                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                cdd.show();
//            }
//        });
//        button_accessories.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CustomDialogClassAccessories cdd = new CustomDialogClassAccessories(ShopNowMain.this);
//                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                cdd.show();
//            }
//        });
//        button_grooming.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                CustomDialogClassGrooming cdd = new CustomDialogClassGrooming(ShopNowMain.this);
//                cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                cdd.show();
//            }
//        });
//    }
}

