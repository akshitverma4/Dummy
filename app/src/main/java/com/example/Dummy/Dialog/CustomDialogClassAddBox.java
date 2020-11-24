package com.example.Dummy.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.Dummy.BoxIt.ChooseTheme;
import com.example.Dummy.R;


public class CustomDialogClassAddBox extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public  Button button ;
    public CustomDialogClassAddBox(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_add_box);
        yes=findViewById(R.id.btn_yes3);
        no=findViewById(R.id.btn_no3);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes3:
                c.startActivity(new Intent(c, ChooseTheme.class));
                break;
            case R.id.btn_no3:
                c.startActivity(new Intent(c, ChooseTheme.class));
                break;
            default:
                break;
        }
        dismiss();
    }
}
