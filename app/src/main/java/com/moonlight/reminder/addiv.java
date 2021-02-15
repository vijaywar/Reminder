package com.moonlight.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class addiv extends AppCompatActivity {
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Calendar c;

    private int mYear, mMonth, mDay, mHour, mMinute;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addiv);
    }

    public void time(View view) {
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        EditText txttime=findViewById(R.id.time);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        txttime.setText(hourOfDay + ":" + minute);
                        mHour=hourOfDay;mMinute=minute;
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    public void date(View view) {
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

EditText txtDate=findViewById(R.id.Date);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        mYear=year;mMonth=monthOfYear;mDay=dayOfMonth;
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void addiv(View view) {
        EditText k=findViewById(R.id.title);
        title=String.valueOf(k.getText());
        reminder iv=new reminder(mYear,mMonth,mDay,mHour,mMinute,title);
        add vi=new add(this);
        vi.addContact(iv);
    }
}

