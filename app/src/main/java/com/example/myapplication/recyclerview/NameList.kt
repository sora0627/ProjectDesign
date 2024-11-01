package com.example.myapplication.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class NameList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // データを用意
        val data = listOf(
            mapOf ("name" to "とり", "detail" to "「とり」の説明文が入ります。"),
            mapOf ("name" to "しか", "detail" to "「しか」の説明文が入ります。"),
            mapOf ("name" to "ぞう", "detail" to "「ぞう」の説明文が入ります。"),
            mapOf ("name" to "きつね", "detail" to "「きつね」の説明文が入ります。"),
            mapOf ("name" to "かば", "detail" to "「かば」の説明文が入ります。"),
            mapOf ("name" to "ライオン", "detail" to "「ライオン」の説明文が入ります。"),
            mapOf ("name" to "パンダ", "detail" to "「パンダ」の説明文が入ります。"),
            mapOf ("name" to "ひつじ", "detail" to "「ひつじ」の説明文が入ります。")
        )

        // ListViewにデータをセットする
        val list = findViewById<ListView>(R.id.list)
        list.adapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            arrayOf("name", "detail"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )
    }
}
