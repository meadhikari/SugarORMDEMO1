package com.bigfootsoftwares.sugarormdemo1;

import com.orm.SugarContext;

import android.app.Application;

public class ClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}