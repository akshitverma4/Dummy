package com.example.Dummy.ui.orders;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class OrdersActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new Orders()).commit();
        }
    }

}

