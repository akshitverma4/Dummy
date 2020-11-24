package com.example.Dummy.ui.book_service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.SearchViewProviders;
import com.example.Dummy.adapter.RecyclerViewAdapterViewAllProviders;
import com.example.Dummy.items.ServiceProviders;

import java.util.ArrayList;

public class BookServiceViewAll extends AppCompatActivity {

    public ArrayList<ServiceProviders> ProvidersList;
    private RecyclerView bookRecyclerView;
    private RecyclerViewAdapterViewAllProviders mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_all_book);

        Intent intent =getIntent();
        id = intent.getIntExtra("id",0);
        ProvidersList = new ArrayList<>();
        for(int i=0 ; i<10; i++) {
            ServiceProviders serviceProviders = new ServiceProviders();
            serviceProviders.setName("Provider "+i);
            ProvidersList.add(serviceProviders);
        }

        //searchView
        TextView search = findViewById(R.id.searchViewBookAll);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("search", "onClick: ");
                startActivity(new Intent(BookServiceViewAll.this, SearchViewProviders.class));
            }
        });
        //back Button
        ImageView back =findViewById(R.id.back_view_all);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buildRecyclerView();
    }


    public void buildRecyclerView() {

        bookRecyclerView = findViewById(R.id.recyclerViewViewAll);
        bookRecyclerView.setHasFixedSize(true);
        mLayoutManager =new LinearLayoutManager(BookServiceViewAll.this);
        mAdapter = new RecyclerViewAdapterViewAllProviders(ProvidersList, BookServiceViewAll.this, id);
        bookRecyclerView.setLayoutManager(mLayoutManager);
        bookRecyclerView.setAdapter(mAdapter);

    }
}
