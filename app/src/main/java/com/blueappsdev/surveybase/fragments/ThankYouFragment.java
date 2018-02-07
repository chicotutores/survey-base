package com.blueappsdev.surveybase.fragments;

import android.support.v4.app.Fragment;

import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.activities.QuestionsActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * Created by douglas_nunes on 1/8/17.
 */

@EFragment(R.layout.fragment_thank_you)
public class ThankYouFragment extends Fragment {

    QuestionsActivity activity;

    @AfterViews
    void afterViews(){

        activity = (QuestionsActivity) getActivity();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        activity.returnToIntro();
                    }
                },
                15000);

    }

}
