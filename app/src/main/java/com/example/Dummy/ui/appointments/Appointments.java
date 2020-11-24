package com.example.Dummy.ui.appointments;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.Dummy.R;
import com.example.Dummy.adapter.RecyclerViewAdapterAppointments;
import com.example.Dummy.adapter.RecyclerViewAdapterServices;
import com.example.Dummy.items.AppointmentItems;
import com.example.Dummy.ui.settings.SettingsViewModel;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Appointments extends Fragment {

    private SettingsViewModel mViewModel;
    private  ImageButton cal_button;
    private MaterialCalendarView calendarView;
    public TextView name;
    public TextView cost;
    public TextView time;
    public TextView duration;
    public String day;
    public String month;
    public String year;
    private ArrayList<AppointmentItems> AppointmentList;
    private RecyclerView appointmentsRecyclerView;
    private RecyclerViewAdapterServices mAdapter1;
    private RecyclerViewAdapterAppointments mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager1;
    private RecyclerView.LayoutManager mLayoutManager2;
    private TextView monthYear;
    private ViewGroup.LayoutParams params;
    private  Boolean flag;
    private ViewGroup.LayoutParams lp;
    public static Appointments newInstance() {
        return new Appointments();
    }


    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.appointments_fragment, container, false);

        name = view.findViewById(R.id.appointment_name);
        cost = view.findViewById(R.id.appointment_cost);
        time = view.findViewById(R.id.appointment_time);
        duration = view.findViewById(R.id.appointment_duration);

        monthYear = view.findViewById(R.id.monthYear);

        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setSelectedDate(CalendarDay.today());


//        calendarView.setVisibility(View.GONE);
//        lp = calendarView.getLayoutParams();
//        lp.height = 150;
//        lp.width= lp.MATCH_PARENT;
//        calendarView.requestLayout();
        Calendar cal = Calendar.getInstance();
        day = new SimpleDateFormat("dd").format(cal.getTime());
        month = new SimpleDateFormat("MMMM").format(cal.getTime());
        year = new SimpleDateFormat("yyyy").format(cal.getTime());
        monthYear.setText(day+" "+ month +" "+year);
        calendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Log.d("today", "onCreateView: "+ new DateFormatSymbols().getMonths()[date.getMonth()-1]);
                        day= String.valueOf(date.getDay());
                        month = new DateFormatSymbols().getMonths()[date.getMonth()-1];
                        year = String.valueOf(date.getYear());
                        monthYear.setText(day+" "+ month +" "+year);


                DotDecorator dotDayDecorator = new DotDecorator(date);
                widget.addDecorator(dotDayDecorator);
                widget.invalidateDecorators();

            }
        });




//        flag =false;
//        cal_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(flag) {
//                 //  calendarView.setVisibility(View.GONE);
//                   calendarView.setVisibility(View.GONE);
//                   monthYear.setVisibility(View.VISIBLE);
//                    cal_button.setBackgroundColor(getResources().getColor(R.color.calender_unpressed));
//                    flag=false;
//                }
//                else {
//                    calendarView.setVisibility(View.VISIBLE);
//                    monthYear.setVisibility(View.GONE);
////                    lp.height = lp.WRAP_CONTENT;
////                    calendarView.requestLayout();
//                    cal_button.setBackgroundColor(getResources().getColor(R.color.calender_pressed));
//                    flag=true;
//                }
//            }
//        });

        AppointmentList =new ArrayList<>();
        for(int i=1;i<6;i++) {
            AppointmentItems appointmentItems = new AppointmentItems();
            appointmentItems.setCost("₹20"+i);
            appointmentItems.setDuration(i+"hours");
            appointmentItems.setTime(i+":00 am");

            AppointmentList.add(appointmentItems);
        }
        buildRecyclerView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        // TODO: Use the ViewModel
    }
    public void buildRecyclerView(View view) {
       appointmentsRecyclerView = view.findViewById(R.id.recyclerView_booked_services);
       appointmentsRecyclerView.setHasFixedSize(true);
        mLayoutManager1 = new LinearLayoutManager(view.getContext());
        mAdapter1 = new RecyclerViewAdapterServices(AppointmentList, view.getContext(), getActivity());
       appointmentsRecyclerView.setLayoutManager(mLayoutManager1);
       appointmentsRecyclerView.setAdapter(mAdapter1);

       appointmentsRecyclerView = view.findViewById(R.id.recyclerView_booked_appointments);
       appointmentsRecyclerView.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(view.getContext());
        mAdapter2 = new RecyclerViewAdapterAppointments(AppointmentList, view.getContext(), getActivity());
       appointmentsRecyclerView.setLayoutManager(mLayoutManager2);
       appointmentsRecyclerView.setAdapter(mAdapter2);

    }


}