package com.github.shadowsocks;

import android.app.Application;

/**
 * Created by terry on 2017/5/14.
 */

public class ShadowsocksApplication extends Application {
    public static ShadowsocksApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
