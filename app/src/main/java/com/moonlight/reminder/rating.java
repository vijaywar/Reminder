package com.moonlight.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class rating extends AppCompatActivity {

    EditText name;
    RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        Toolbar tool=findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        name=findViewById(R.id.name);
        rating=findViewById(R.id.ratingBar);
    }

    public void submit(View view) {


        if(!name.getText().toString().equals("")){


            int no=0;

            name.setText("");
            rating.setRating(0);
            Toast.makeText(this,"Thanks for giving rating :"+String.valueOf(rating.getRating()),Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Enter Name",Toast.LENGTH_SHORT).show();
        }

    }
}