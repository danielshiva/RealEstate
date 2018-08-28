package com.example.dgconstrution.utils;

import android.app.Application;
import android.graphics.Typeface;


public class MyApplication extends Application {

    // Custom Light Font
    public Typeface getCustomLightFont() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/lato-light.ttf");
        return custom_font;
    }

    // Custom Bold Font
    public Typeface getCustomBoldFont() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/lato-bold.ttf");
        return custom_font;
    }

    // Custom Regular Font
    public Typeface getCustomRegularFont() {
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/lato-regular.ttf");
        return custom_font;
    }

}
