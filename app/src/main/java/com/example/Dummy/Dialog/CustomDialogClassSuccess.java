package com.example.Dummy.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.Dummy.R;
import com.example.Dummy.ui.book_service.BookForm2;


public class CustomDialogClassSuccess extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    BookForm2 bookForm2 = new BookForm2();
    String gActivity;


    public CustomDialogClassSuccess(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        gActivity= c.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_success);
        yes = (Button) findViewById(R.id.btn_yes);
        yes.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                if(gActivity.contains("BookForm2"))
                 dismiss();
                else
                    c.finish();
                break;
            default:
                break;
        }
        dismiss();
    }
}
