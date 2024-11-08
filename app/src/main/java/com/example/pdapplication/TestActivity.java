package com.example.pdapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

import android.os.Bundle;
import android.widget.TextView;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        TaskDbConnect task = new TaskDbConnect(this);
        task.execute();
    }
}

class TaskDbConnect extends AsyncTask<Void, Void, String>{
    TestActivity activity;
    public TaskDbConnect(TestActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params){
        String text1="";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.11.62:3306/pd_db?autoReconnect=true&useSSL=false","ProjectDesign","nishikawa");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from stores");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int location = resultSet.getInt(2);
                String tid = resultSet.getString(3);
                String time = resultSet.getString(4);
                text1 += id + " " + location + " " + tid + " " + time + " " + "\r\n";
            }
        }catch (Exception e){
            text1 = e.getMessage();
        }

        return  text1;
    }

    protected void onPostExecute(String result){
        super.onPostExecute(result);
        TextView textView = (TextView)activity.findViewById(R.id.textview1);
        textView.setText(result);
    }
}