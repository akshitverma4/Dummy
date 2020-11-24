package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.Dummy.R;

public class RegisterPageProvider2 extends AppCompatActivity {
    EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_provider2);

        number = findViewById(R.id.enteredNumber2);
        number.setFocusableInTouchMode(true);
        number.requestFocus();

    }

    public void goBackToRegister1(View view) {
        startActivity(new Intent(RegisterPageProvider2.this, RegisterPageProvider1.class));

    }

    public void goToRegisterPage3(View view) {
        Intent intent = new Intent(RegisterPageProvider2.this, RegisterPageProvider3.class);
        intent.putExtra("number", number.getText().toString());
        startActivity(intent);

    }
}