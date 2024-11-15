
package com.example.pdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.pdapplication.db.DatabaseHelper;
import com.example.pdapplication.db.Stores;
import com.example.pdapplication.db.StoresAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String input_name = "";
    public String input_options = "";
    public String input_areas = "";

    private DatabaseHelper databaseHelper;
    private StoresAdapter storesAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        List<Stores> stores = databaseHelper.getAllStores(input_name, input_options, input_areas);
        storesAdapter = new StoresAdapter(this, stores);
        ListView storeListView = findViewById(R.id.storeListView);
        storeListView.setAdapter(storesAdapter);


        //ListView 画面遷移
        storeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                Stores stores = storesAdapter.getItem(position);
                intent.putExtra("Name", stores.getName());
                intent.putExtra("Address", stores.getAddress());
                intent.putExtra("Tel",stores.getTel());
                startActivity(intent);
            }
        });

        final EditText editText = (EditText) findViewById(R.id.search_bar);
        final Button search_button = (Button) findViewById(R.id.apply_filter_button);
        final Spinner spinner_options = (Spinner) findViewById(R.id.category_spinner);
        final Spinner spinner_areas = (Spinner) findViewById(R.id.category_spinner1);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_name = editText.getText().toString();
                input_options = spinner_options.getSelectedItem().toString();
                if (input_options.equals("すべて")) {input_options = "";}
                input_areas = spinner_areas.getSelectedItem().toString();
                if (input_areas.equals("すべて")) {input_areas = "";}
                databaseHelper = new DatabaseHelper(MainActivity.this);
                List<Stores> stores = databaseHelper.getAllStores(input_name, input_options, input_areas);
                storesAdapter = new StoresAdapter(MainActivity.this, stores);
                ListView storeListView = findViewById(R.id.storeListView);
                storeListView.setAdapter(storesAdapter);
            }
        });

        //ホーム画面遷移
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //設定画面遷移
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
