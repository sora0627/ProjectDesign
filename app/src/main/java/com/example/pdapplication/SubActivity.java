package com.example.pdapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pdapplication.db.DatabaseHelper;
import com.example.pdapplication.db.Stores;
import com.example.pdapplication.db.StoresAdapter;

import java.util.List;

public class SubActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private StoresAdapter storesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        databaseHelper = new DatabaseHelper(this);

        List<Stores> stores = databaseHelper.getAllStores();

        storesAdapter = new StoresAdapter(this, stores);
        ListView storeListView = findViewById(R.id.storeListView);
        storeListView.setAdapter(storesAdapter);
    }

}