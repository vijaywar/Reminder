package com.moonlight.reminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton img;
    ListView layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.listview);
        //img=findViewById(R.id.imageButton);
        add vi=new add(MainActivity.this);
        System.out.println(vi.getAllContacts().size()+"................................................................................");
        if(vi.getAllContacts().size()!=0 ) {
            CustomListAdapter adapterinstance = new CustomListAdapter(this, vi.getAllContacts());
            layout.setAdapter(adapterinstance);
        }
    }

    public void add(View view) {
        Intent i=new Intent(MainActivity.this,addiv.class);
        startActivity(i);
        System.out.println("CLicked ao");
    }
}
/*

 img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.custom);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Dismissed..!!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
 */


class CustomListAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<reminder> customListDataModelArrayList =  new ArrayList<reminder>();
    LayoutInflater layoutInflater = null;

    public CustomListAdapter(Activity activity, ArrayList customListDataModelArray){
        this.activity=activity;
        this.customListDataModelArrayList = customListDataModelArray;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        System.out.println("sicze iasodfsl if sdfj......................"+customListDataModelArrayList.size());
        return customListDataModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return customListDataModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class ViewHolder{
        //RatingBar rating;
        ImageButton tick;
        TextView timea,titlea;
        ConstraintLayout lay;
    }
    ViewHolder viewHolder = null;

    // this method  is called each time for arraylist data size.
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View vi=view;
        final int pos = position;
        if(vi == null){

            // create  viewholder object for list_rowcell View.
            viewHolder = new ViewHolder();
            // inflate list_rowcell for each row
            vi = layoutInflater.inflate(R.layout.adapter,null);
            //  viewHolder.rating = (RatingBar) vi.findViewById(R.id.ratingBar2);

            viewHolder.titlea = (TextView) vi.findViewById(R.id.rem);
            viewHolder.tick=(ImageButton) vi.findViewById(R.id.tick);
            viewHolder.timea=(TextView) vi.findViewById(R.id.time);
            viewHolder.lay=(ConstraintLayout)vi.findViewById(R.id.layout);
            //viewHolder.tv_discription = (TextView) vi.findViewById(R.id.tv_discription);
            /*We can use setTag() and getTag() to set and get custom objects as per our requirement.
            The setTag() method takes an argument of type Object, and getTag() returns an Object.*/
            vi.setTag(viewHolder);
        }else {

            /* We recycle a View that already exists */
            viewHolder= (ViewHolder) vi.getTag();
        }
        reminder data=customListDataModelArrayList.get(pos);
        // viewHolder.image_view.setImageResource(customListDataModelArrayList.get(pos).getImage_id());
        viewHolder.titlea.setText(data.gt());
        String k=String.valueOf(data.gd())+" ->"+String.valueOf(data.gh())+"-"+String.valueOf(data.gmi());
        viewHolder.timea.setText(k);
        if(position%2==0)
        viewHolder.lay.setBackgroundColor(Color.parseColor("#dcaafc") );
        //  System.out.println(data.getPhoneNumber());
        // viewHolder.rating.setRating( Float.parseFloat(data.getPhoneNumber()));
        // viewHolder.tv_discription.setText(customListDataModelArrayList.get(pos).getImageDiscription());
System.out.println("called and set value ................"+k+"slkdfj"+pos+"->"+position);
        return vi;
    }}
