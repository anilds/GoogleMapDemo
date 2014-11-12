package com.example.googlemap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

	public class MainActivity extends FragmentActivity {
		 
	    // Google Map
	    private GoogleMap googleMap;
	    static final LatLng BANGALORE = new LatLng(12.985112,77.589741);
	 
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
	 
	    private void initilizeMap() {
	       
	    	SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
	        googleMap = mapFragment.getMap();
	        Marker bangalore = googleMap.addMarker(new MarkerOptions().position(BANGALORE)
                    .title("Bangalore"));
	     
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BANGALORE, 15));

            // Zoom in, animating the camera.
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
	        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	 
	        RadioGroup rgViews = (RadioGroup) findViewById(R.id.rg_views);
	 
	        rgViews.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	 
	            @Override
	            public void onCheckedChanged(RadioGroup group, int checkedId) {
	                if(checkedId == R.id.rb_normal){
	                    googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	                }else if(checkedId == R.id.rb_satellite){
	                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	                }else if(checkedId == R.id.rb_terrain){
	                    googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	                }
	            }
	        });
	        
	 

	    }
	 
	    @Override
	    protected void onResume() {
	        super.onResume();
	        initilizeMap();
	    }
	    
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	    	// TODO Auto-generated method stub
	    	MenuInflater menuInflater = getMenuInflater();
	    	menuInflater.inflate(R.menu.activity_main, menu);
	    	return true;
	    }

	    
	 
	}