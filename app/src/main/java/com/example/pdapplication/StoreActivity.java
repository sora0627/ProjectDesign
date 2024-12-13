package com.example.pdapplication;

import android.graphics.drawable.Drawable;
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
import org.osmdroid.views.overlay.Marker;


public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        setContentView(R.layout.activity_store);

        Map();

        Intent intent = getIntent();

        TextView NameTextView = findViewById(R.id.textView2);
        TextView TelTextView = findViewById(R.id.textView5);

        NameTextView.setText(intent.getStringExtra("Name"));
        TelTextView.setText(intent.getStringExtra("Tel"));

    }
    private void Map(){
        MapView mapView = (MapView) findViewById(R.id.mapView);
        IMapController mapController = mapView.getController();
        mapController.setZoom(18.0);
        GeoPoint centerPoint = new GeoPoint(36.578194, 136.648046);
        mapController.setCenter(centerPoint);

        mapView.setMultiTouchControls(true);

        mapView.setHorizontalMapRepetitionEnabled(true);
        mapView.setVerticalMapRepetitionEnabled(false);
        mapView.setScrollableAreaLimitLatitude(MapView.getTileSystem().getMaxLatitude(),MapView.getTileSystem().getMinLatitude(), 0);
        mapView.setMinZoomLevel(6.0);

        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(36.57826, 136.6486));
        marker.setTitle(getIntent().getStringExtra("Name"));
        mapView.getOverlays().add(marker);

        Drawable icon = getResources().getDrawable(R.drawable.marker);
        marker.setIcon(icon);
    }

    private  void Marker(){

    }
}
