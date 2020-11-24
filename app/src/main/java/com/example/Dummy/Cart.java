package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.Dummy.adapter.RecyclerViewAdapterCart;
import com.example.Dummy.items.CartItem;

public class Cart extends AppCompatActivity {

    private TextView mTextView;
    public ArrayList<CartItem> ProductsList;
    private RecyclerView cartRecyclerView;
    private RecyclerViewAdapterCart mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageButton back;
    TextView qty;
    TextView qtyAdd;
    TextView qtySub;
    Integer iQty=1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        addToCart(1);
        buildRecyclerView();

        Button placeOrder = findViewById(R.id.place_order);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Cart.this, SelectAddress.class);
                startActivity(intent);
            }
        });

        back = findViewById(R.id.back_appoint_summary);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        qty = findViewById(R.id.qty);
//        qty.setText(iQty);
//        qtyAdd = findViewById(R.id.add_qty_row);
//        qtySub = findViewById(R.id.sub_qty_row);
//        qtyAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                iQty++;
//                qty.setText(iQty);
//            }
//        });
//        qtySub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(iQty>0)
//                    iQty--;
//                qty.setText(iQty);
//            }
//        });
    }

    public void addToCart(int n){
        ProductsList = new ArrayList<>();
        for(int i =1;i<=n;i++) {
            CartItem products = new CartItem();
            products.setName("Dog healthy food , large, 15 Inch");
            ProductsList.add(products);
        }

    }

    public void buildRecyclerView() {

        cartRecyclerView = findViewById(R.id.recyclerView_cart);
        cartRecyclerView.setHasFixedSize(true);
        mLayoutManager =new LinearLayoutManager(getApplicationContext());
        mAdapter = new RecyclerViewAdapterCart(ProductsList);
        cartRecyclerView.setLayoutManager(mLayoutManager);
        cartRecyclerView.setAdapter(mAdapter);

    }

}
