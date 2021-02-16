package com.moonlight.reminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class add extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "title";
    private static final String KEY_Y = "y";
    private static final String KEY_M = "m";
    private static final String KEY_D = "d";
    private static final String KEY_H = "h";
    private static final String KEY_MI = "mi";
    private static final String idl="intentid";

    public add(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " TEXT PRIMARY KEY," + KEY_Y + " INTEGER,"
                + KEY_M + " INTEGER,"+ KEY_D + " INTEGER,"
                + KEY_H + " INTEGER,"+ KEY_MI + " INTEGER,"+idl+" INTEGER"
                  + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addContact(reminder add) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, add.gt()); // Contact1 Name
        values.put(KEY_Y, add.gy());
        values.put(KEY_M, add.gm());
        values.put(KEY_D, add.gd());
        values.put(KEY_H, add.gh());
        values.put(KEY_MI, add.gmi());
        values.put(idl,add.gid());
        // Contact1 Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    reminder getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_Y,KEY_M,KEY_D,KEY_D,KEY_H,KEY_MI,idl }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        reminder contact = new reminder(
        Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),cursor.getString(0),Integer.parseInt(cursor.getString(6)));
        // return contact
        return contact;
    }

    // code to get all contacts in a list view
    public ArrayList<reminder> getAllContacts() {
        ArrayList<reminder> contactList = new ArrayList<reminder>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                reminder contact = new reminder(
                        Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                        Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)),
                        Integer.parseInt(cursor.getString(5)),cursor.getString(0),Integer.parseInt(cursor.getString(6)));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // code to update the single contact
    public int updateContact(reminder add) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, add.gt()); // Contact1 Name
        values.put(KEY_Y, add.gy());
        values.put(KEY_M, add.gm());
        values.put(KEY_D, add.gd());
        values.put(KEY_H, add.gh());
        values.put(KEY_MI, add.gmi());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(add.gt()) });
    }

    // Deleting single contact
    public void deleteContact(reminder contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.gt()) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt=cursor.getCount();
        cursor.close();

        return cnt;
    }

}
