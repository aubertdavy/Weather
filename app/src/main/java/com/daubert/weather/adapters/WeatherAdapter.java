package com.daubert.weather.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daubert.weather.R;
import com.daubert.weather.entities.Weather;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by daubert on 17/02/2017.
 */

public class WeatherAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList mWeathers;
    private LayoutInflater layoutInflater;

    public WeatherAdapter(Context context, ArrayList weathers) {
        mContext = context;
        mWeathers = weathers;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mWeathers.size();
    }

    @Override
    public Object getItem(int position) {
        return mWeathers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_weather_item, null);
        }

        Weather weather = (Weather)mWeathers.get(position);
        if (weather != null) {
            ((TextView)convertView.findViewById(R.id.txt_date)).setText(weather.getDate());

            Picasso.with(mContext)
                   .load(weather.getUrlIcon())
                   .into((ImageView)convertView.findViewById(R.id.img_icon));
        }

        return convertView;
    }
}