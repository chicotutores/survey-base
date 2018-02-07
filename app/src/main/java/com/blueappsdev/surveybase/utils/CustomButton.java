package com.blueappsdev.surveybase.utils;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.Button;

import com.blueappsdev.surveybase.R;

/**
 * Created by douglas_nunes on 1/6/17.
 */

public class CustomButton extends Button {

    GradientDrawable gradientDrawable = new GradientDrawable();

    public CustomButton(Context context, AttributeSet attrs) {

        super(context, attrs);

        setupButton(context);

    }

    void setupButton(Context context){

        setTypeface(Typefaces.regular(context));

        setTextColor(ContextCompat.getColor(context, R.color.black));

        gradientDrawable.setCornerRadius(30);

        gradientDrawable.setColor(ContextCompat.getColor(context, R.color.yellow));

        setBackground(gradientDrawable);

    }

}
