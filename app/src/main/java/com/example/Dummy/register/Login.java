package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.Dummy.DrawerActivity;
import com.example.Dummy.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView register = findViewById(R.id.login_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, RegisterPage1.class));
            }
        });
    }

    public void loginWithGoogle(View view) {
    }


    public void loginButtonClick(View view) {
        startActivity(new Intent(Login.this, DrawerActivity.class));

    }
}