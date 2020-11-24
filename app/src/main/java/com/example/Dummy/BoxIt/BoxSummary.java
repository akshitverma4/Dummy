package com.example.Dummy.BoxIt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.Dummy.R;

public class BoxSummary extends AppCompatActivity {
    TextView qty1;
    TextView qty2;
    TextView qty3;
    TextView sub1;
    TextView sub2;
    TextView sub3;
    TextView add1;
    TextView add2;
    TextView add3;
    Integer qtyCnt1=1;
    Integer qtyCnt2=1;
    Integer qtyCnt3=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_summary);

        ImageView back = findViewById(R.id.back_box_summary);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        qty1 = findViewById(R.id.qty_pd1);
        qty2 = findViewById(R.id.qty_pd2);
        qty3 = findViewById(R.id.qty_pd3);
        sub1 = findViewById(R.id.sub_qty_pd1);
        sub2 = findViewById(R.id.sub_qty_pd2);
        sub3 = findViewById(R.id.sub_qty_pd3);
        add1 = findViewById(R.id.add_qty_pd1);
        add2 = findViewById(R.id.add_qty_pd2);
        add3 = findViewById(R.id.add_qty_pd3);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtyCnt1++;
                qty1.setText(qtyCnt1.toString());
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtyCnt2++;
                qty2.setText(qtyCnt2.toString());
            }
        });
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qtyCnt3++;
                qty3.setText(qtyCnt3.toString());
            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtyCnt1!=1) {
                    qtyCnt1--;
                    qty1.setText(qtyCnt1.toString());
                }
            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtyCnt2!=1) {
                    qtyCnt2--;
                    qty2.setText(qtyCnt2.toString());
                }
            }
        });
        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtyCnt3!=1) {
                    qtyCnt3--;
                    qty3.setText(qtyCnt3.toString());
                }
            }
        });


        Button next =findViewById(R.id.next_box_summary);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BoxSummary.this,BoxSummary2.class));
            }
        });

    }
}