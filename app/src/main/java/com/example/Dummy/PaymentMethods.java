package com.example.Dummy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.Payments.CardPayment;
import com.example.Dummy.Payments.UPIPayment;



public class PaymentMethods extends AppCompatActivity {
    RadioGroup radioGroup ;
    RadioButton radioButton;
    RadioButton cash;
    Integer id;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_methods);
        Intent intent = getIntent();
        id= intent.getIntExtra("id",0);
        cash= findViewById(R.id.radioButtonCOD);
        if(id==1)
            cash.setVisibility(View.GONE);
        radioGroup = findViewById(R.id.radioGroup);
        Button payment_continue = findViewById(R.id.deliverToAddress);


        payment_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Continue();
            }
        });

        ImageView back = findViewById(R.id.back_payment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void  Continue(){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        if(radioButton.getId()==R.id.radioButtonCard) {
            Intent intent = new Intent(PaymentMethods.this, CardPayment.class);
            startActivity(intent);
        }if(radioButton.getId()==R.id.radioButtonUPI) {
            Intent intent = new Intent(PaymentMethods.this, UPIPayment.class);
            startActivity(intent);
        }if(radioButton.getId()==R.id.radioButtonCOD) {

        }
    }
}
