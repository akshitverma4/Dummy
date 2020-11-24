package com.example.Dummy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Filters extends AppCompatActivity {
    TextView price;
    TextView petType;
    TextView accessories;
    TextView grooming;
    Integer iFiltersCount=0;
    TextView filtersCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filters);

        petType = findViewById(R.id.filterPetType);;
        price = findViewById(R.id.filterPrice);
        accessories = findViewById(R.id.filterAccessories);
        grooming = findViewById(R.id.filterGrooming);
        filtersCount = findViewById(R.id.filtersCount);
        filtersCount.setText(iFiltersCount.toString());
        final LinearLayout filterLayout = findViewById(R.id.filterLayout);
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterLayout.removeAllViews();
                CheckBox ch = new CheckBox(Filters.this);
                ch.setText("Rs 500 and Below");
                filterLayout.addView(ch);
                CheckBox ch2 = new CheckBox(Filters.this);
                ch2.setText("Rs 501 - Rs 1000");
                filterLayout.addView(ch2);
                CheckBox ch3 = new CheckBox(Filters.this);
                ch3.setText("Rs 1001 - Rs 2000");
                filterLayout.addView(ch3);
                CheckBox ch4 = new CheckBox(Filters.this);
                ch4.setText("Rs 2001 and above");
                filterLayout.addView(ch4);
                price.setBackgroundColor(getColor(R.color.white));
                petType.setBackgroundColor(getColor(R.color.grey));
                accessories.setBackgroundColor(getColor(R.color.grey));
                grooming.setBackgroundColor(getColor(R.color.grey));
            }
        });
        petType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterLayout.removeAllViews();
                CheckBox ch = new CheckBox(Filters.this);
                ch.setText("Cat");
                filterLayout.addView(ch);
                CheckBox ch2 = new CheckBox(Filters.this);
                ch2.setText("Dog");
                filterLayout.addView(ch2);

                petType.setBackgroundColor(getColor(R.color.white));
                price.setBackgroundColor(getColor(R.color.grey));
                accessories.setBackgroundColor(getColor(R.color.grey));
                grooming.setBackgroundColor(getColor(R.color.grey));
            }
        });
        petType.performClick();
        accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterLayout.removeAllViews();
                CheckBox ch = new CheckBox(Filters.this);
                ch.setText("Chains");
                filterLayout.addView(ch);
                CheckBox ch2 = new CheckBox(Filters.this);
                ch2.setText("Belts");
                filterLayout.addView(ch2);
                CheckBox ch3 = new CheckBox(Filters.this);
                ch3.setText("Collars");
                filterLayout.addView(ch3);
                CheckBox ch4 = new CheckBox(Filters.this);
                ch4.setText("Cages");
                filterLayout.addView(ch4);
                CheckBox ch5 = new CheckBox(Filters.this);
                ch5.setText("Bowls");
                filterLayout.addView(ch5);

                accessories.setBackgroundColor(getColor(R.color.white));
                price.setBackgroundColor(getColor(R.color.grey));
                petType.setBackgroundColor(getColor(R.color.grey));
                grooming.setBackgroundColor(getColor(R.color.grey));
            }
        });
        grooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterLayout.removeAllViews();
                CheckBox ch = new CheckBox(Filters.this);
                ch.setText("Brushes");
                filterLayout.addView(ch);
                CheckBox ch2 = new CheckBox(Filters.this);
                ch2.setText("Shampoos");
                filterLayout.addView(ch2);
                CheckBox ch3 = new CheckBox(Filters.this);
                ch3.setText("Soaps");
                filterLayout.addView(ch3);

                grooming.setBackgroundColor(getColor(R.color.white));
                price.setBackgroundColor(getColor(R.color.grey));
                petType.setBackgroundColor(getColor(R.color.grey));
                accessories.setBackgroundColor(getColor(R.color.grey));
            }
        });

        ImageButton back = findViewById(R.id.back_filters);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button applyFilters = findViewById(R.id.applyFilters);
        applyFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}