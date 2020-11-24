package com.example.Dummy.ui.appointments;

import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;


public class DotDecorator extends AppCompatActivity implements DayViewDecorator {

    private final int color = Color.parseColor("#FF0000");
    private final CalendarDay dates;

    public DotDecorator(CalendarDay dates) {

        this.dates = dates;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day){
        return dates==day;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, color));
    }

}

