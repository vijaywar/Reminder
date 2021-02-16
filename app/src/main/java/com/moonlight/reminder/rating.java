package com.moonlight.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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
        getSupportActionBar().setTitle(null);
        name=findViewById(R.id.name);
        rating=findViewById(R.id.ratingBar);
    }
    public void home(View view) {
        Intent i=new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(i);
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