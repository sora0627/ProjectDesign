package com.example.pdapplication;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.TextView;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class StoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_store);

        Map();

        Intent intent = getIntent();

        TextView NameTextView = findViewById(R.id.textView2);
        TextView AddressTextView = findViewById(R.id.textView4);
        TextView TelTextView = findViewById(R.id.textView5);
        TextView URLTextView = findViewById(R.id.text);

        NameTextView.setText(intent.getStringExtra("Name"));
        AddressTextView.setText(intent.getStringExtra("Address"));
        TelTextView.setText(intent.getStringExtra("Tel"));
        URLTextView.setText(intent.getStringExtra("URL"));

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
    private void Map(){
        MapView mapView = (MapView) findViewById(R.id.mapView);
        IMapController mapController = mapView.getController();
        mapController.setZoom(6.0);
        GeoPoint centerPoint = new GeoPoint(38.00, 138.00);
        mapController.setCenter(centerPoint);

        mapView.setMultiTouchControls(true);

        mapView.setHorizontalMapRepetitionEnabled(true);
        mapView.setVerticalMapRepetitionEnabled(false);
        mapView.setScrollableAreaLimitLatitude(MapView.getTileSystem().getMaxLatitude(),MapView.getTileSystem().getMinLatitude(), 0);
        mapView.setMinZoomLevel(3.0);
    }
}
