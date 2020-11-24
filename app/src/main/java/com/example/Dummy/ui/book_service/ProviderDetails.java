package com.example.Dummy.ui.book_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.R;
import com.example.Dummy.adapter.RecyclerViewAdapterProvidersFeedback;
import com.example.Dummy.items.ProvidersFeedback;

import java.util.ArrayList;

public class ProviderDetails extends AppCompatActivity {

    public ArrayList<ProvidersFeedback> FeedbackList;
    private RecyclerView bookRecyclerView;
    private RecyclerViewAdapterProvidersFeedback mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_details);

        FeedbackList = new ArrayList<>();
        for(int i=0 ; i<7; i++) {
            ProvidersFeedback providersFeedback = new ProvidersFeedback();
            providersFeedback.setName("Customer "+i);
            providersFeedback.setFeedback("He is so kind. I had a very great experience with him and my doggo is happy too."+i);
            FeedbackList.add(providersFeedback);
        }

        book = findViewById(R.id.book_details);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProviderDetails.this, BookForm1.class);
                ProviderDetails.this.startActivity(intent);
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

        bookRecyclerView = findViewById(R.id.recyclerViewProvidersFeedback);
        bookRecyclerView.setHasFixedSize(true);
        mLayoutManager =new LinearLayoutManager(ProviderDetails.this);
        mAdapter = new RecyclerViewAdapterProvidersFeedback(FeedbackList, ProviderDetails.this);
        bookRecyclerView.setLayoutManager(mLayoutManager);
        bookRecyclerView.setAdapter(mAdapter);

    }
}
