package com.littersun.beforeapponcreate;

import android.app.Application;
import android.util.Log;

import com.littersun.mylibrary.Configuration;
import com.littersun.mylibrary.MySdk;

public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("xxx", "DemoApplication onCreate: ");
        MySdk.start(new Configuration("xx", "yy"));
    }
}
