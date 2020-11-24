package com.example.Dummy.BoxIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.Dummy.Dialog.CustomDialogClassAddBox;
import com.example.Dummy.R;

public class ChoosePlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_plan);
        LinearLayout sixMonth = findViewById(R.id.sixMonthLayout);
        LinearLayout monthly = findViewById(R.id.monthlyLayout);

        sixMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoosePlan.this, ChooseTheme.class));
            }
        });

        monthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClassAddBox cd = new CustomDialogClassAddBox(ChoosePlan.this);
                cd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cd.show();

            }
        });

        ImageView back = findViewById(R.id.back_choose_plan);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}