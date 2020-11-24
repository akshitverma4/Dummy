package com.example.Dummy.ui.book_service;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.Dialog.CustomDialogClassSuccess;
import com.example.Dummy.R;

public class BookForm2 extends AppCompatActivity{
    CalendarView calendarView;
    TextView enterDate;
    String date;
    String time;
    EditText email;
    EditText phn;
    RadioGroup serviceOccur;
    RadioGroup travel;
    RadioButton service2;
    RadioButton travel3;
    String[] services = {"Grooming service (₹200)","Service2 (₹300)", "Service3 (₹499)"};

    Spinner spin_service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_form2);

        spin_service = findViewById(R.id.spinner_service);
        spin_service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                R.layout.spinner_item,
                services);

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                R.layout
                        .simple_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin_service.setAdapter(ad);

        calendarView = findViewById(R.id.calendarView2);
        calendarView.setVisibility(View.GONE);
        enterDate = findViewById(R.id.enterDate);
        serviceOccur = findViewById(R.id.serviceOccur);
        service2 = findViewById(R.id.service2);

        enterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date= dayOfMonth +"-"+ (month+1)+"-"+year;
                enterDate.setText(date);
                calendarView.setVisibility(View.GONE);
            }
        });

//        enterTime = findViewById(R.id.enterTime);
//        enterTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment timePicker = new TimePickerFragment();
//                timePicker.show(getSupportFragmentManager(), "time picker");
//            }
//
//        });


        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //enterDate.setError(null);
                enterDate.setError(null);


//                if(enterDate.getText().toString().equals("")){
//                    enterDate.setError("Can't be empty");
//                    enterDate.requestFocus();
//                }
               if(enterDate.getText().toString().equals("")){
                    enterDate.setError("Can't be empty");
                    enterDate.requestFocus();
                }
//                else if(serviceOccur.getCheckedRadioButtonId()==-1)
//                    service3.setError("choose one");

                else {
//                Intent intent = new Intent(BookForm2.this, BookForm2.class);
//                startActivity(intent);
                    CustomDialogClassSuccess cdd = new CustomDialogClassSuccess(BookForm2.this);
                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    cdd.show();
                }
            }
        });
        //back Button
        ImageView back =findViewById(R.id.back_view_all);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
//    @Override
//    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//        if(hourOfDay>12){
//            hourOfDay-=12;
//            time = String.format("%02d:%02dPM", hourOfDay, minute);
//            //time= hourOfDay+ ":"+minute+"PM";
//        }
//        else{
//            time = String.format("%02d:%02dAM", hourOfDay, minute);
//        }
//
//        enterDate.setText(time);
//    }
}
