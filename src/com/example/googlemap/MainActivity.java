package com.example.googlemap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.MapActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;


	public class MainActivity extends Activity {
		 
	    // Google Map
	    private GoogleMap googleMap;
	    static final LatLng BANALORE = new LatLng(12.985112,77.589741);
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	 
	        try {
	            // Loading map
	            initilizeMap();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	    }
	 
	    /**
	     * function to load map. If map is not created it will create it for you
	     * */
	    private void initilizeMap() {
	        if (googleMap == null) {
	            googleMap = ((MapFragment) getFragmentManager().findFragmentById (R.id.map)).getMap();
	            Marker hamburg = googleMap.addMarker(new MarkerOptions().position(BANALORE)
	                    .title("Bangalore"));
	         //Move the camera instantly to hamburg with a zoom of 15.
	            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BANALORE, 15));

	            // Zoom in, animating the camera.
	            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	            // check if map is created successfully or not
	            if (googleMap == null) {
	                Toast.makeText(getApplicationContext(),
	                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
	                        .show();
	            }
	        }
	    }
	 
	    @Override
	    protected void onResume() {
	        super.onResume();
	        initilizeMap();
	    }
	 
	}