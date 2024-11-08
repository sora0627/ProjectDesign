package com.example.pdapplication.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.helper.widget.Layer;

import java.util.List;

public class StoresAdapter extends BaseAdapter {

    private Context context;
    private List<Stores> storesList;

    public  StoresAdapter(Context context, List<Stores> storesList){
        this.context = context;
        this.storesList = storesList;
    }

    @Override
    public int getCount(){
        return storesList.size();
    }

    @Override
    public Stores getItem(int position){
        return storesList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        Stores stores = getItem(position);
        TextView text1 = convertView.findViewById(android.R.id.text1);
        TextView text2 = convertView.findViewById(android.R.id.text2);
        text1.setText(stores.getName());
        text2.setText(stores.getAddress());
        //text2.setText(stores.getTel());

        return convertView;
    }
}
