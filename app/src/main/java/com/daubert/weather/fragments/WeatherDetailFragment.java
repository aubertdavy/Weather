package com.daubert.weather.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daubert.weather.R;
import com.daubert.weather.entities.Weather;

/**
 * Created by daubert on 17/02/2017.
 */

public class WeatherDetailFragment extends BaseWeatherFragment {
    private static final String TAG = WeatherDetailFragment.class.getSimpleName();

    public static WeatherDetailFragment newInstance(Weather weather) {
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        args.putString(API_KEY_DATE, weather.getDate());
        args.putString(API_KEY_SPEED, weather.getSpeed());
        args.putString(API_KEY_NIGHT, weather.getTempNight());
        args.putString(API_KEY_TEMP_DAY, weather.getTempDay());
        args.putString(API_KEY_TEMP_MAX, weather.getTempMax());
        args.putString(API_KEY_TEMP_MIN, weather.getTempMin());
        args.putString(API_KEY_HUMIDITY, weather.getHumidity());
        args.putString(API_KEY_PRESSURE, weather.getPressure());
        args.putString(API_KEY_MORNING, weather.getTempMorning());
        args.putString(API_KEY_EVENING, weather.getTempEvening());
        weatherDetailFragment.setArguments(args);
        return weatherDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ((TextView)view.findViewById(R.id.txt_date)).setText(getArguments().getString(API_KEY_DATE));
        ((TextView)view.findViewById(R.id.txt_temp)).setText("Température " + getArguments().getString(API_KEY_TEMP_DAY) + "° (Max " +  getArguments().getString(API_KEY_TEMP_MAX) +
                "°, Min " + getArguments().getString(API_KEY_TEMP_MIN) + "°)");
        ((TextView)view.findViewById(R.id.txt_temp_day)).setText("Matin " + getArguments().getString(API_KEY_MORNING) + "°, Midi " +  getArguments().getString(API_KEY_TEMP_MAX) +
                "°, Soirée " + getArguments().getString(API_KEY_TEMP_MIN) + "°");
        ((TextView)view.findViewById(R.id.txt_pressure)).setText("Pression atmosphérique " + getArguments().getString(API_KEY_PRESSURE));
        ((TextView)view.findViewById(R.id.txt_humidity)).setText("Humditité " + getArguments().getString(API_KEY_HUMIDITY) + "%");
        ((TextView)view.findViewById(R.id.txt_speed)).setText("Vitesse " + getArguments().getString(API_KEY_SPEED));
    }
}