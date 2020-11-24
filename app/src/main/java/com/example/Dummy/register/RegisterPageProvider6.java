package com.example.Dummy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Dummy.R;

public class RegisterPageProvider6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_provider6);
        Button next =findViewById(R.id.next_register6);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(RegisterPageProvider6.this,RegisterPageProvider6.class));
            }
        });
    }
}