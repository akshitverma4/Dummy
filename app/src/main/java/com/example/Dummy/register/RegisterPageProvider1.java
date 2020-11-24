package com.example.Dummy.register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.R;

public class RegisterPageProvider1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_provider1);
        TextView login = findViewById(R.id.register_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterPageProvider1.this, Login.class));
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
                startActivity(new Intent(getApplicationContext(), RegisterPageProvider2.class));
            }
        });
    }


}