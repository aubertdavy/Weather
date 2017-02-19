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
        args.putParcelable("parcelable", weather);
        weatherDetailFragment.setArguments(args);
        return weatherDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Weather weather = getArguments().getParcelable("parcelable");
        if (weather == null)
            return;

        ((TextView)view.findViewById(R.id.txt_date)).setText(weather.getDate());
        ((TextView)view.findViewById(R.id.txt_speed)).setText("Vitesse " + weather.getSpeed());
        ((TextView)view.findViewById(R.id.txt_humidity)).setText("Humditité " + weather.getHumidity() + "%");
        ((TextView)view.findViewById(R.id.txt_pressure)).setText("Pression atmosphérique " + weather.getHumidity());
        ((TextView)view.findViewById(R.id.txt_temp)).setText("Température " + weather.getTempDay() + "° (Max " +  weather.getTempMax() + "°, Min " + weather.getTempMin() + "°)");
        ((TextView)view.findViewById(R.id.txt_temp_day)).setText("Matin " + weather.getTempMorning() + "°, Midi " +  weather.getTempEvening() + "°, Soirée " + weather.getTempNight() + "°");
    }
}