package com.padc.aml.w4_ex;

import android.app.Application;
import android.content.Context;

/**
 * Created by user on 7/2/2016.
 */
public class W4ExApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }

    // object level context can't be called in class level static method
    public static Context getContext() {
        return context;
    }
}
