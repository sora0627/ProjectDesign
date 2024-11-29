package com.example.pdapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pdapplication.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PD2.sqlite3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_STORES = "stores";
    private static final String STORES_COLUMN_ID = "id";
    private static final String STORES_COLUMN_NAME = "name";
    private static final String STORES_COLUMN_ADDRESS = "address";
    private static final String STORES_COLUMN_TEL = "tel";
    private static final String STORES_COLUMN_OPTION = "option";
    private static final String STORES_COLUMN_AREA = "area";
    private static final String STORES_COLUMN_URL = "url";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        String createTableQuery = "CREATE TABLE " + TABLE_NAME_STORES + " (" +
                STORES_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                STORES_COLUMN_NAME + " TEXT, " +
                STORES_COLUMN_ADDRESS + " TEXT, " +
                STORES_COLUMN_TEL + " TEXT, " +
                STORES_COLUMN_OPTION + " TEXT, " +
                STORES_COLUMN_AREA + " TEXT, " +
                STORES_COLUMN_URL + "TEXT)";
        database.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_STORES);
    }

    //
    public List<Stores> getAllStores(String input_name, String input_options, String input_areas){
        input_name ="%" + input_name + "%";
        input_options ="%" + input_options + "%";
        input_areas = "%" + input_areas + "%";
        List<Stores> stores = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String query = "select * from " + TABLE_NAME_STORES + " where "
                + STORES_COLUMN_NAME + " like ? and "
                + STORES_COLUMN_OPTION + " like ? and "
                + STORES_COLUMN_AREA + " like ?";
        Cursor cursor = database.rawQuery(query, new String[]{input_name, input_options, input_areas});
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(STORES_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_ADDRESS));
            String tel = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_TEL));
            String option = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_OPTION));
            String area = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_AREA));
            String url = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_URL));
            stores.add(new Stores(id, name, address, tel, option, area, url));
        }
        cursor.close();
        database.close();
        return stores;
    }
}
