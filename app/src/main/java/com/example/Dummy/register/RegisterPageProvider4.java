package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.Dummy.R;

public class RegisterPageProvider4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_provider4);
        final Button button3 = findViewById(R.id.next_register);

        final CheckBox checkBox = findViewById(R.id.checkBox2);
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkBox.isChecked())
//                    button3.setBackground(getDrawable(R.drawable.add_to_cart_button));
//                else
//                    button3.setBackground(getDrawable(R.drawable.register_1_et_bg));
//            }
//        });

    }


    public void goToHomePageFromRegister4(View view) {
        startActivity(new Intent(getApplicationContext(), RegisterPageProvider5.class));

    }
}