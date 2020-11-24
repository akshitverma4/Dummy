package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.Dummy.R;

public class RegisterPage2 extends AppCompatActivity {
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page2);

        number = findViewById(R.id.enteredNumber);
        number.setFocusableInTouchMode(true);
        number.requestFocus();

    }

    public void goBackToRegister1(View view) {
        startActivity(new Intent(RegisterPage2.this, RegisterPage1.class));

    }

    public void goToRegisterPage3(View view) {
        Intent intent = new Intent(RegisterPage2.this, RegisterPage3.class);
        intent.putExtra("number", number.getText().toString());
        startActivity(intent);

    }
}