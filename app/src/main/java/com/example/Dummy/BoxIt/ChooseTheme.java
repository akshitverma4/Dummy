package com.example.Dummy.BoxIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.Dummy.R;

public class ChooseTheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_theme);

        ImageView a =findViewById(R.id.homeAloneImg);
        ImageView b =findViewById(R.id.dogsGivingImg);
        ImageView c =findViewById(R.id.surpriseMeImg);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseTheme.this, BoxSummary.class));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseTheme.this, BoxSummary.class));
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseTheme.this, BoxSummary.class));
            }
        });

        ImageView back = findViewById(R.id.back_choose_theme);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}