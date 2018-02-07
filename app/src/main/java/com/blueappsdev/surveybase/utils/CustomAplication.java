package com.blueappsdev.surveybase.utils;

import android.app.Application;

import st.lowlevel.storo.StoroBuilder;

/**
 * Created by douglas_nunes on 1/7/17.
 */

public class CustomAplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        StoroBuilder.configure(50000)
                .setDefaultCacheDirectory(this)
                .initialize();

    }
}
