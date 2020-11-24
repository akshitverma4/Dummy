package com.example.Dummy.ui.chat_with_experts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.PaymentMethods;
import com.example.Dummy.R;

public class AppointmentSummary extends AppCompatActivity {
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_summary);
        final Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        Button pay = findViewById(R.id.pay_appointment_sum);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(AppointmentSummary.this, PaymentMethods.class);
                intent1.putExtra("id",id);
                startActivity(intent1);
            }
        });



        ImageView back =findViewById(R.id.back_appoint_summary);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}