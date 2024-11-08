package com.example.pdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleActivity extends AppCompatActivity{

    @Override
    protected  void onCreate(Bundle saveInstanceStage) {
        super.onCreate(saveInstanceStage);
        setContentView(R.layout.activity_title);

        findViewById(R.id.seni_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TitleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}