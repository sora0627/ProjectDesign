package com.example.pdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceStage) {
        super.onCreate(saveInstanceStage);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchText = query;
                // 検索文字列を使用するコードを追加
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 入力中の文字列が変更されたときに呼ばれる
                return false;
            }
        });
    }
}