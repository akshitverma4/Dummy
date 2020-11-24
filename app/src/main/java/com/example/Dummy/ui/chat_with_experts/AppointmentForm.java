package com.example.Dummy.ui.chat_with_experts;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Dummy.R;


public class AppointmentForm  extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    EditText name;
    EditText email;
    EditText mobile;
    TextView date;
    //TextView time;
    CalendarView calendarView;
    EditText address;
    EditText message;
    Spinner spin_service;
    Integer id = 0;
    String[] services = {"Grooming service (₹200)","Service2 (₹300)", "Service3 (₹499)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_with_experts_fragment);
        Intent intent = getIntent();
        id= intent.getIntExtra("id",0);
        name=findViewById(R.id.cwe_name);
        email=findViewById(R.id.cwe_email);
        mobile=findViewById(R.id.cwe_mobile);
        date=findViewById(R.id.cwe_date);
        calendarView=findViewById(R.id.calendarView3);
        calendarView.setVisibility(View.GONE);
        address=findViewById(R.id.cwe_address);
        message=findViewById(R.id.cwe_message);
        Button book = findViewById(R.id.cwe_book);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String sDate;
                sDate= dayOfMonth +"-"+ (month+1)+"-"+year;
                date.setText(sDate);
                calendarView.setVisibility(View.GONE);
            }
        });

//        time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DialogFragment timePicker = new TimePickerFragment();
//                timePicker.show(getSupportFragmentManager(), "time picker");
//
//            }
//
//        });

        spin_service = findViewById(R.id.spinner_service2);
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
                AppointmentForm.this,
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


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setError(null);
                email.setError(null);
                mobile.setError(null);
                date.setError(null);
       //         time.setError(null);
                address.setError(null);
                message.setError(null);

//                if(name.getText().toString().equals(""))
//                    name.setError("Can't be empty");
//                else if(email.getText().toString().equals(""))
//                    email.setError("Can't be empty");
//                else if(mobile.getText().toString().equals(""))
//                    mobile.setError("Can't be empty");
//                else if(mobile.getText().length()!=10)
//                    mobile.setError("Please enter a valid number");
               if(date.getText().toString().equals(""))
                    date.setError("Can't be empty");
//                else if(time.getText().toString().equals(""))
//                    time.setError("Can't be empty");
//                else if(address.getText().toString().equals(""))
//                    address.setError("Can't be empty");
                else if(message.getText().toString().equals(""))
                    message.setError("Can't be empty");
                else{
                    Intent intent = new Intent(AppointmentForm.this, AppointmentSummary.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
               }
            }
        });

        ImageView back =findViewById(R.id.back_chat_with_experts);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String sTime;
        Log.d("hour", "onTimeSet: "+hourOfDay);
        if(hourOfDay==0)
            sTime = String.format("%02d:%02dPM", (hourOfDay+12), minute);
        else if(hourOfDay>=13){
            hourOfDay-=12;
            sTime = String.format("%02d:%02dPM", hourOfDay, minute);
            //time= hourOfDay+ ":"+minute+"PM";
        }

        else{
            sTime = String.format("%02d:%02dAM", hourOfDay, minute);
        }

     //   time.setText(sTime);
    }


}