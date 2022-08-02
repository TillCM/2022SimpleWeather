package com.vc.simpleweather2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final String TAG ="AccuWeatherURL";
    Fragment FiveDayWeather;
    Fragment Tide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FiveDayWeather = new FiveDayWeather();
        Tide =new TideFragment();
        URL accuWeatherURL = NetworkUtil.buildURL();
        Log.i(TAG, "onCreate: " + accuWeatherURL);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.weather_frame, FiveDayWeather);
        transaction.replace(R.id.tide_frame,Tide);
        transaction.commit();


    }
}