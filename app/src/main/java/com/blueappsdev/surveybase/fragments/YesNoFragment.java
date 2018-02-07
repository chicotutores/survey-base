package com.blueappsdev.surveybase.fragments;


import android.support.v4.app.Fragment;

import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.activities.QuestionsActivity;
import com.blueappsdev.surveybase.models.Question;
import com.blueappsdev.surveybase.utils.Constants;
import com.blueappsdev.surveybase.utils.CustomTextView;
import com.blueappsdev.surveybase.utils.MakeRequest;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;

import okhttp3.Response;

/**
 * Created by douglas_nunes on 1/7/17.
 */

@EFragment(R.layout.fragment_yes_no)
public class YesNoFragment extends Fragment {

    @ViewById
    CustomTextView titleTextView;

    QuestionsActivity activity;

    Question question;

    @AfterViews
    void afterViews(){

        activity = (QuestionsActivity) getActivity();

        question = activity.currentQuestion;

        titleTextView.setText(question.getTitle());

    }

    @Background
    void anserQuestion(int answer){

        activity.showLoading();

        try{

            HashMap<String, Object> params = new HashMap<>();

            params.put("questionId", question.getId());
            params.put("clientId", activity.clientId);
            params.put("option", answer);

            Response response = MakeRequest.post(Constants.url("answerQuestion/"), params);

            activity.dismissLoading();

            activity.replaceFragment();

        }catch (Exception e){

            activity.replaceFragment();

        }

    }

    @Click(R.id.yesButton)
    void yesClicked(){

        anserQuestion(1);

    }

    @Click(R.id.noButton)
    void noClicked(){

        anserQuestion(0);

    }

}
