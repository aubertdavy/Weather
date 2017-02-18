package com.daubert.weather.entities;

import com.daubert.weather.helpers.DateHelper;

/**
 * Created by daubert on 17/02/2017.
 */


public class Weather {
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
}