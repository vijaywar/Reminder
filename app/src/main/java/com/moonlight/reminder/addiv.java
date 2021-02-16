package com.moonlight.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class addiv extends AppCompatActivity {
    PendingIntent pendingIntent,pendingIntentk;
    AlarmManager alarmManager,alarmManagerk;
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
        add vi=new add(this);
        int idl=vi.getContactsCount()+1;
     try{
        c.set(mYear,mMonth,mDay,mHour,mMinute);
         long i=c.getTimeInMillis();
         long dur= ((c.getTimeInMillis()-System.currentTimeMillis()))/1000;

         if(title!=""){
             if(dur>0) {
                 Intent intent = new Intent(this, AlarmManagerBroadcast.class);
                 pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), idl, intent, 0);
                 alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                 alarmManager.set(AlarmManager.RTC_WAKEUP, i, pendingIntent);

                 Intent intentk = new Intent(this, notirec.class);
                 intentk.putExtra("remTitle", title);
                 pendingIntentk = PendingIntent.getBroadcast(this.getApplicationContext(), idl + 50000, intentk, 0);
                 alarmManagerk = (AlarmManager) getSystemService(ALARM_SERVICE);
                 alarmManagerk.set(AlarmManager.RTC_WAKEUP, i, pendingIntentk);


                 System.out.println(c.getTimeInMillis()+" "+System.currentTimeMillis()+" "+c.getTime());
                 Toast.makeText(this, "Alarm set in " +dur  + " seconds",Toast.LENGTH_SHORT).show();
                 reminder iv=new reminder(mYear,mMonth,mDay,mHour,mMinute,title,idl);
                 try {
                     vi.addContact(iv);
                     k.setText("");
                 }
                 catch (Exception e){
                     Toast.makeText(this,"Try different title!",Toast.LENGTH_SHORT).show();
                 }}
             else{
                 Toast.makeText(this,"Time passed !",Toast.LENGTH_SHORT).show();
             }}
         else{
             Toast.makeText(this,"Title can't be empty!",Toast.LENGTH_SHORT).show();
         }
     }
     catch (Exception e){
         Toast.makeText(this,"Set date and time Using buttons!",Toast.LENGTH_SHORT).show();
     }

    }

    public void home(View view) {
        Intent i=new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
        super.onBackPressed();
    }
}

