
package com.example.pdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;

import com.example.pdapplication.db.DatabaseHelper;
import com.example.pdapplication.db.Stores;
import com.example.pdapplication.db.StoresAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private StoresAdapter storesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        databaseHelper = new DatabaseHelper(this);

        List<Stores> stores = databaseHelper.getAllStores();

        storesAdapter = new StoresAdapter(this, stores);
        ListView storeListView = findViewById(R.id.storeListView);
        storeListView.setAdapter(storesAdapter);

        EditText editText = findViewById(R.id.search_bar);
        Button search_button = findViewById(R.id.apply_filter_button);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_data = editText.getText().toString();
            }
        });

        //ボタンを押したとき(ホームに戻る)
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
