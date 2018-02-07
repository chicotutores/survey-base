package com.blueappsdev.surveybase.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by douglas_nunes on 1/6/17.
 */

public class Typefaces {

    public static Typeface regular(Context context){

        return Typeface.createFromAsset(context.getAssets(), "fonts/DINPro-Regular.otf");

    }

    public static Typeface medium(Context context){

        return Typeface.createFromAsset(context.getAssets(), "fonts/DINPro-Medium.otf");

    }

    public static Typeface light(Context context){

        return Typeface.createFromAsset(context.getAssets(), "fonts/DINPro-Light.otf");

    }

    public static Typeface black(Context context){

        return Typeface.createFromAsset(context.getAssets(), "fonts/DINPro-Blac.otf");

    }

    public static Typeface bold(Context context){

        return Typeface.createFromAsset(context.getAssets(), "fonts/DINPro-Bold.otf");

    }

}
