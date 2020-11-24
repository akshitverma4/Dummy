package com.example.Dummy.ui.book_service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.AddNewPet;
import com.example.Dummy.BoxIt.ChoosePlan;
import com.example.Dummy.R;

public class BookForm1 extends AppCompatActivity {

    Integer id =0;
    String[] pets = {"pet1","pet 2", "pet3"};
    Spinner spin_pet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_form1);
        Intent intent = getIntent();
        id=intent.getIntExtra("id",0);
        spin_pet = findViewById(R.id.spinner_my_pets);
        spin_pet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                R.layout.spinner_item,
                pets);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                R.layout
                        .simple_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin_pet.setAdapter(ad);

        Button addPet = findViewById(R.id.button_add_pet);
        addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookForm1.this, AddNewPet.class);
                startActivity(intent);
            }
        });


        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(id==1){
                    Intent intent = new Intent(BookForm1.this, ChoosePlan.class);
                    startActivity(intent);
                    }
                    else
                        startActivity(new Intent(BookForm1.this, BookForm2.class));
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

    }

}
