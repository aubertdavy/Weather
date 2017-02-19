package com.daubert.weather.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.daubert.weather.helpers.DateHelper;

/**
 * Created by daubert on 17/02/2017.
 */


public class Weather implements Parcelable {
    private String mDt;
    private String mSpeed;
    private String mTempDay;
    private String mTempMax;
    private String mTempMin;
    private String mUrlIcon;
    private String mPressure;
    private String mHumidity;
    private String mTempNight;
    private String mTempMorning;
    private String mTempEvening;

    public void setDt(String dt) {
        mDt = dt;
    }

    public void setPressure(String pressure) {
        mPressure = pressure;
    }

    public void setTempNight(String tempNight) {
        mTempNight = tempNight;
    }

    public void setTempMorning(String tempMorning) {
        mTempMorning = tempMorning;
    }

    public void setTempEvening(String tempEvening) {
        mTempEvening = tempEvening;
    }

    public void setTempDay(String tempDay) {
        mTempDay = tempDay;
    }

    public void setTempMax(String tempMax) {
        mTempMax = tempMax;
    }

    public void setTempMin(String tempMin) {
        mTempMin = tempMin;
    }

    public void setHumidity(String humidity) {
        mHumidity = humidity;
    }

    public void setSpeed(String speed) {
        mSpeed = speed;
    }

    public void setmUrlIcon(String urlIcon) {
        mUrlIcon = urlIcon;
    }

    public String getDt() {
        return mDt;
    }

    public String getDate() {
        return DateHelper.MillToStrDate(mDt);
    }

    public String getPressure() {
        return mPressure;
    }

    public String getTempDay() {
        return mTempDay;
    }

    public String getTempMax() {
        return mTempMax;
    }

    public String getTempMin() {
        return mTempMin;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public String getUrlIcon() {
        return mUrlIcon;
    }

    public String getSpeed() {
        return mSpeed;
    }

    public String getTempMorning() {
        return mTempMorning;
    }

    public String getTempEvening() {
        return mTempEvening;
    }

    public String getTempNight() {
        return mTempNight;
    }

    public Weather() {}

    public Weather(Parcel read) {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {}

    public static final Parcelable.Creator<Weather> CREATOR = new Parcelable.Creator<Weather>() {
                @Override
                public Weather createFromParcel(Parcel source) {
                    return new Weather(source);
                }
                @Override
                public Weather[] newArray(int size) {
                    return new Weather[size];
                }
            };
}