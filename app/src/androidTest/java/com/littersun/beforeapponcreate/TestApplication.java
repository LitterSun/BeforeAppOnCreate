package com.littersun.beforeapponcreate;

import android.app.Application;
import android.util.Log;

import com.littersun.mylibrary.Configuration;
import com.littersun.mylibrary.MySdk;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("xxx", "TestApplication onCreate: ");
        MySdk.start(new Configuration("other", null));
    }
}
