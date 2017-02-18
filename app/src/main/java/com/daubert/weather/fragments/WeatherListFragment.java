package com.daubert.weather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.daubert.weather.R;
import com.daubert.weather.adapters.WeatherAdapter;
import com.daubert.weather.entities.Weather;
import com.daubert.weather.utils.ApplicationController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by daubert on 17/02/2017.
 */

public class WeatherListFragment extends BaseWeatherFragment {
    private static final String TAG = WeatherListFragment.class.getSimpleName();
    private static final String URL_ICON = "http://openweathermap.org/img/w/";
    private static final String URL_WEATHER_API = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Paris&units=metric&cnt=5&appid=";

    private OnItemSelectedListener mListener;
    private ArrayList<Weather> mArrWeather;
    private ListView mList;

    public interface OnItemSelectedListener {
        void onRssItemSelected(Weather weather);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            mListener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()  +
                    " doit implémenter WeatherListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mList = (ListView) view.findViewById(R.id.weater_list);
        if (mList != null) {
            mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mListener.onRssItemSelected(mArrWeather.get(position));
                }
            });
        }

        requestedWeather();
    }

    private void requestedWeather() {
        JsonObjectRequest jsRequest = new JsonObjectRequest(Request.Method.GET, URL_WEATHER_API + getString(R.string.weather_api_key), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                mArrWeather = new ArrayList<Weather>();
                try {
                    JSONArray arrList = response.getJSONArray(API_KEY_LIST);
                    for (int i = 0; i < arrList.length(); i++) {
                        JSONObject jsList = (JSONObject) arrList.get(i);
                        JSONArray arrWt = jsList.getJSONArray(API_KEY_WEATHER);
                        JSONObject jsTemp = (JSONObject) jsList.get(API_KEY_TEMP);
                        JSONObject jsWeather = (JSONObject) arrWt.get(0);

                        Weather weather = new Weather();
                        weather.setDt(jsList.getString(API_KEY_DATE));
                        weather.setTempDay(jsTemp.getString(API_KEY_TEMP_DAY));
                        weather.setTempMax(jsTemp.getString(API_KEY_TEMP_MAX));
                        weather.setTempMin(jsTemp.getString(API_KEY_TEMP_MIN));
                        weather.setTempMorning(jsTemp.getString(API_KEY_MORNING));
                        weather.setTempEvening(jsTemp.getString(API_KEY_EVENING));
                        weather.setTempNight(jsTemp.getString(API_KEY_NIGHT));
                        weather.setHumidity(jsList.getString(API_KEY_HUMIDITY));
                        weather.setPressure(jsList.getString(API_KEY_PRESSURE));
                        weather.setSpeed(jsList.getString(API_KEY_SPEED));
                        weather.setmUrlIcon(URL_ICON + jsWeather.getString(API_KEY_ICON) + ".png");
                        mArrWeather.add(weather);
                    }

                    mList.setAdapter(new WeatherAdapter(getContext(), mArrWeather));

                } catch (JSONException error) {
                    VolleyLog.e(TAG, error.getMessage());
                    Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, error.getMessage());
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        ApplicationController.getInstance().addToRequestQueue(jsRequest);
    }
}
