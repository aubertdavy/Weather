package com.daubert.weather.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.daubert.weather.R;
import com.daubert.weather.entities.Weather;
import com.daubert.weather.fragments.WeatherDetailFragment;
import com.daubert.weather.fragments.WeatherListFragment;

/**
 * Created by daubert on 17/02/2017.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherListFragment.OnItemSelectedListener {
    public static final String TAG = WeatherActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_main_place_holder, WeatherListFragment.newInstance());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
      if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
          getSupportFragmentManager().popBackStack();
      } else {
          super.onBackPressed();
      }
  }

    @Override
    public void onItemSelected(Weather weather) {
        int resId = R.id.fragment_main_place_holder;
        if ((FrameLayout) findViewById(R.id.fragment_detail_place_holder) != null) {
            resId = R.id.fragment_detail_place_holder;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(resId, WeatherDetailFragment.newInstance(weather));
        ft.addToBackStack(null);
        ft.commit();
    }
}
