package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.ui.orders.OrdersActivity;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        TextView myPets = findViewById(R.id.to_my_pets);
        myPets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyProfile.this, MyPets.class));
            }
        });

        TextView myOrders = findViewById(R.id.to_my_orders);
        myOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(new Intent(MyProfile.this, OrdersActivity.class));

            }
        });

        TextView accSet = findViewById(R.id.account_settings);
        accSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MyProfile.this, AccountSettings.class));
            }
        });

        ImageView back =findViewById(R.id.back_my_profile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}