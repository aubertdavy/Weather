package com.daubert.weather.helpers;

import java.util.Calendar;

/**
 * Created by AUBERT on 18/02/2017.
 */

public class DateHelper {

    public static String MillToStrDate(String timeStamp) {
        long ts = Long.valueOf(timeStamp);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(ts);

        int mMinute = calendar.get(Calendar.MINUTE);
        int mMonth = calendar.get(Calendar.MONTH) + 1;
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR_OF_DAY);

        return String.format("%02d", mDay) + "/" + String.format("%02d", mMonth) + " à " +
                String.format("%02d", mHour) + ":" + String.format("%02d", mMinute);
    }
}
