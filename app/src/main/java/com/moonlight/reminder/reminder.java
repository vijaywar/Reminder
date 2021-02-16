package com.moonlight.reminder;

public class reminder {
    private int mYear, mMonth, mDay, mHour, mMinute,id;String title;
    public reminder(int y,int m,int d,int h,int mi ,String title,int id){
        mYear=y;mMonth=m;mDay=d;mHour=h;mMinute=mi;this.title=title;this.id=id;
    }
    public int gy(){return this.mYear;}
    public int gm(){return this.mMonth;}
    public int gd(){return this.mDay;}
    public int gh(){return this.mHour;}
    public int gmi(){return this.mMinute;}
    public void sy(int iv){this.mYear=iv;}
    public void sm(int iv){this.mMonth=iv;}
    public void sd(int iv){this.mDay=iv;}
    public void sh(int iv){this.mHour=iv;}
    public void smi(int iv){this.mMinute=iv;}
    public String gt(){return this.title;}
    public void mt(String ti){this.title=ti;}
    public void sid(int id){this.id=id;}
    public int gid(){return this.id;}
}
