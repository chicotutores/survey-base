package com.blueappsdev.surveybase.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.blueappsdev.surveybase.R;

/**
 * Created by douglas_nunes on 1/6/17.
 */

public class CustomTextView extends TextView {

    int fontFamily = 0;

    public CustomTextView(Context context, AttributeSet attrs) {

        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView, 0, 0);

        fontFamily = typedArray.getInt(R.styleable.CustomTextView_dinFamily, 0);

        setupTextView(context);

    }

    void setupTextView(Context context){

        setTextColor(ContextCompat.getColor(context, android.R.color.white));

        switch (fontFamily){

            case 0 : DEFAULT :
                setTypeface(Typefaces.regular(context));
                break;

            case 1:
                setTypeface(Typefaces.medium(context));
                break;

            case 2:
                setTypeface(Typefaces.light(context));
                break;

            case 3:
                setTypeface(Typefaces.black(context));
                break;

            case 4:
                setTypeface(Typefaces.bold(context));
                break;

        }

    }
}
