package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.Dummy.R;

public class LoginOrRegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register_page);


        TextView regAsPro =findViewById(R.id.reg_as_pro);
        regAsPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginOrRegisterPage.this,RegisterPageProvider1.class));
            }
        });
    }

    public void goToSignInPage(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));

    }

    public void goToregisterPage1(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterPage1.class));

    }
}