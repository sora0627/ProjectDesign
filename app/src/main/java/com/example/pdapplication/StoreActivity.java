package com.example.pdapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Intent intent = getIntent();

        TextView NameTextView = findViewById(R.id.NameTextView);
        TextView AddressTextView = findViewById(R.id.AddressTextView);

        NameTextView.setText(intent.getStringExtra("Name"));
        AddressTextView.setText(intent.getStringExtra("Address"));

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
