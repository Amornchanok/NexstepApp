package com.amornchanok.nextstep_app;

import android.app.Application;

import com.amornchanok.nextstep_app.model.Partners;

public class MyApplication extends Application {
    public static Partners partner = new Partners();
}