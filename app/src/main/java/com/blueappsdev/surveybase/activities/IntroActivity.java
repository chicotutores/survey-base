package com.blueappsdev.surveybase.activities;

import android.support.v7.app.AppCompatActivity;

import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.utils.CustomButton;
import com.thunderrise.animations.PulseAnimation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_intro)
public class IntroActivity extends AppCompatActivity {

    @ViewById
    CustomButton continueButton;

    @AfterViews
    void afterViews(){

        PulseAnimation.create().with(continueButton)
                .setDuration(1000)
                .setRepeatCount(PulseAnimation.INFINITE)
                .setRepeatMode(PulseAnimation.REVERSE)
                .start();

    }

    @Click(R.id.continueButton)
    void continueClicked(){

        RegisterActivity_.intent(this).start();

    }
}
