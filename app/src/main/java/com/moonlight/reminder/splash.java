package com.moonlight.reminder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class splash extends AppCompatActivity {
    private Handler progressBarHandler = new Handler();
    ProgressBar pr;
    TextView message;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    pr=findViewById(R.id.progressBar);
    pr.setProgress(0);
    pr.setMax(100);

    message=findViewById(R.id.message);
    //runningPBar();


        final int[] i = {0};
        new Thread(new Runnable() {
            public void run() {
                while (i[0] < 100) {
                    // performing operation
                    i[0] = doOperation(i[0]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Updating the progress bar
                    progressBarHandler.post(new Runnable() {
                        public void run() {
                            pr.setProgress(i[0]);
                            message.setText(Integer.toString(i[0])+"%");
                        }
                    });
                }
                // performing operation if file is downloaded,
                if (i[0] >= 100) {
                    // sleeping for 1 second after operation completed
                    Intent Ma=new Intent(splash.this,MainActivity.class);
                    startActivity(Ma);
                    // close the progress bar dialog

                }
            }
        }).start();

        }
        int doOperation(int i){
        return i+1;
        }

    public void runningPBar(){
        int i=0;//Creating an integer variable and intializing it to 0

        while( i<=100)
        {
            try{
                Thread.sleep(50);//Pausing execution for 50 milliseconds
                pr.setProgress(i);//Setting value of Progress Bar
                message.setText(Integer.toString(i)+"%");//Setting text of the message JLabel
                i++;
                if(i==100){
                    Intent Ma=new Intent(this,MainActivity.class);
                    startActivity(Ma);
                }
                   // frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
}