package com.moonlight.reminder;

import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class notis extends AppCompatActivity {

    TextView tv;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.notifiiv);

       // tv = findViewById(R.id.tv);


        Bundle b1= RemoteInput.getResultsFromIntent(getIntent());
        if(b1 != null)
        {
            //tv.setText(b1.getString(notirec.myKey));
        }

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(notirec.notification_ID);
        Intent iv=new Intent(this,MainActivity.class);
        iv.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(iv);
    }
}
