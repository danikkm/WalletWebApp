package com.danikkk.walletWebApp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDateAndTime {
    public static String getCurrentDateAndTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(c.getTime());
    }
}
