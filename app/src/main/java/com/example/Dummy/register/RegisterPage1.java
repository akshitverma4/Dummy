package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.Dummy.R;

public class RegisterPage1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page1);
        TextView login = findViewById(R.id.register_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterPage1.this, Login.class));
            }
        });

        final TextView enterMob = findViewById(R.id.enterNumBtn);
        final CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()) {
                    enterMob.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    enterMob.setTextColor(Color.parseColor("#FFA500"));
                }
                else {
                    enterMob.setBackground(getDrawable(R.drawable.register_1_et_bg));
                    enterMob.setTextColor(Color.parseColor("#FFFFFFFF"));
                }
            }
        });

        enterMob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked())
                startActivity(new Intent(getApplicationContext(), RegisterPage2.class));
            }
        });
    }


}