package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Dummy.adapter.RecyclerViewAdapterMyPets;
import com.example.Dummy.items.MyPetsItem;


import java.util.ArrayList;

public class MyPets extends AppCompatActivity {
    private ArrayList<MyPetsItem> Petslist;
    private RecyclerView myPetRecyclerView;
    private RecyclerViewAdapterMyPets mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_pets);
        Petslist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MyPetsItem myPetsItem = new MyPetsItem();
            myPetsItem.setPetName("Bruno"+ i);
            myPetsItem.setPetType("dog");
            Petslist.add(myPetsItem);
        }

        ImageButton back = findViewById(R.id.back_mypets);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button addPet = findViewById(R.id.addAPet);
        addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyPets.this, AddNewPet.class);
                startActivity(intent);
            }
        });
        buildRecyclerView();

    }

    public void buildRecyclerView() {
        myPetRecyclerView = findViewById(R.id.recyclerViewMyPets);
        myPetRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mAdapter = new RecyclerViewAdapterMyPets(Petslist,MyPets.this);
        myPetRecyclerView.setLayoutManager(mLayoutManager);
        myPetRecyclerView.setAdapter(mAdapter);

    }
}