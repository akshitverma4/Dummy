package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

import com.example.Dummy.R;

public class RegisterPage3 extends AppCompatActivity {

    Pinview pinview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page3);
        pinview = findViewById(R.id.myPinView);

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        TextView textView = findViewById(R.id.textViewOtp);
        pinview.showCursor(true);
        pinview.setFocusableInTouchMode(true);
        pinview.requestFocus();
        textView.setText("We have sent you a SMS on +91"+ number + " with a 6-digit verification code(OTP).");
        final TextView otpTimer = findViewById(R.id.otp_timer);
        new CountDownTimer(45000, 1000) {

            public void onTick(long millisUntilFinished) {
                otpTimer.setText("Resend OTP in " + millisUntilFinished / 1000+" seconds");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                otpTimer.setText("Resend OTP");
            }

        }.start();
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean fromUser) {
                Toast.makeText(getApplicationContext(), pinview.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void goBackToRegister2(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterPage2.class));

    }

    public void goToRegisterPage4(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterPage4.class));

    }
}