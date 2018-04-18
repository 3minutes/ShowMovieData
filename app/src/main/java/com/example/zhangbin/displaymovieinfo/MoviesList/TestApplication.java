package com.example.zhangbin.displaymovieinfo.MoviesList;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by zhangbin on 5/3/2018.
 */

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
