package com.example.Dummy.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.Dummy.R;


public class CustomDialogClassAccessories extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    public  Button button ;
    public CustomDialogClassAccessories(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_accessories);
//        yes = (Button) findViewById(R.id.btn_belts);
//        no = (Button) findViewById(R.id.btn_bowls);
//        button = findViewById(R.id.button_accessories);
//        yes.setOnClickListener(this);
//        no.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_belts:
//              //  button.setText("Belts");
//                dismiss();
//                break;
//            case R.id.btn_bowls:
//              //  button.setText("Bowls");
//                dismiss();
//                break;
//            default:
//                break;
//        }
        dismiss();
    }
}
