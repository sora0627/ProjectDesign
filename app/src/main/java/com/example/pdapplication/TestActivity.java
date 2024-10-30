package com.example.pdapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public  class TestActivity  extends  AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceStage){
        super.onCreate(savedInstanceStage);
        setContentView(R.layout.activity_test);

        TaskDbConnect task = new TaskDbConnect(this);
        task.execute();
    }
}

class TaskDbConnect extends AsyncTask<Void, Void, String> {
    TestActivity activity;

    public TaskDbConnect(TestActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params){
        String text1="";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://172.18.6.149:3306/pd_db","riku","Asj!xI5j1923");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from stores");

            while(rs.next()){
                int id = rs.getInt(1);
                int location = rs.getInt(2);
                String tid = rs.getString(3);
                String time = rs.getString(4);
                text1 += id+" "+location+" "+tid+" "+time+" "+"\r\n";
            }
        }catch (Exception error){
            text1=error.getMessage();
        }
        return text1;
    }

    protected void onPostExecute(String result){
        super.onPostExecute(result);
        TextView textView = (TextView) activity.findViewById(R.id.textView1);
        textView.setText(result);
    }

}
