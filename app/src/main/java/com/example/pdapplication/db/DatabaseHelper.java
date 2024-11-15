package com.example.pdapplication.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pdapplication.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PD.sqlite3";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_STORES = "stores";
    private static final String STORES_COLUMN_ID = "id";
    private static final String STORES_COLUMN_NAME = "name";
    private static final String STORES_COLUMN_ADDRESS = "address";
    private static final String STORES_COLUMN_TEL = "tel";
    private static final String STORES_COLUMN_OPTION = "option";
    private static final String STORES_COLUMN_AREA = "area";

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
                STORES_COLUMN_AREA + " TEXT)";
        database.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_STORES);
    }

    //
    public List<Stores> getAllStores(String input_name, String input_options, String input_areas){
        List<Stores> stores = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(
                TABLE_NAME_STORES,
                null,
                STORES_COLUMN_NAME + " like ?",
                new String[]{"%" + input_name + "%"},
                null,
                null,
                null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(STORES_COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_ADDRESS));
            String tel = cursor.getString(cursor.getColumnIndexOrThrow(STORES_COLUMN_TEL));
            stores.add(new Stores(id, name, address, tel));
        }
        cursor.close();
        database.close();
        return stores;
    }
}
