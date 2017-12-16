package com.example.hee.shelter;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by hee on 2017-11-11.
 */

public class SecondActivity extends AppCompatActivity implements OnMapReadyCallback{

GoogleMap mGoogleMap=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        TextView shName = (TextView)findViewById(R.id.shelterNameView2);
        TextView shLocation = (TextView)findViewById(R.id.shelterLocationView2);
        TextView shProvider = (TextView)findViewById(R.id.shelterProviderView2);
TextView shlatlong=(TextView)findViewById(R.id.shelterlatlong1);

        Intent intent = getIntent();
        shName.setText(intent.getStringExtra("name"));
        shLocation.setText(intent.getStringExtra("location"));
        shProvider.setText(intent.getStringExtra("provider"));

        getAddress(shName);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng syd=new LatLng(37.588,127.006);
        mGoogleMap = googleMap;
        googleMap.addMarker(new MarkerOptions().position(syd));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(syd,15));
    }
    private void getAddress(TextView shName){
        TextView addressTextView=(TextView)findViewById(R.id.shelterNameView2);
        try{
            Geocoder geocoder=new Geocoder(this, Locale.KOREA);
            List<Address> addresses=geocoder.getFromLocationName(String.valueOf(shName),1);
            if(addresses.size()>0){
                Address bestResult=(Address) addresses.get(0);
                addressTextView.setText(String.format("[%s,%s]",
                        bestResult.getLatitude(),
                        bestResult.getLongitude()));

            }
        }catch (IOException e){
            Log.e(getClass().toString(),"Failed in using Geocoder",e);
            return;
        }

    }
}

