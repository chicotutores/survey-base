package com.blueappsdev.surveybase.fragments;

import android.support.v4.app.Fragment;

import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.activities.QuestionsActivity;
import com.blueappsdev.surveybase.models.Question;
import com.blueappsdev.surveybase.utils.Constants;
import com.blueappsdev.surveybase.utils.CustomTextView;
import com.blueappsdev.surveybase.utils.MakeRequest;
import com.google.gson.Gson;

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

@EFragment(R.layout.fragment_notes)
public class NotesFragment extends Fragment {

    @ViewById
    CustomTextView titleTextView;

    QuestionsActivity activity;

    Question question;

    Gson gson = new Gson();

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
            params.put("score", answer);

            Response response = MakeRequest.post(Constants.url("answerQuestion/"), params);

            activity.dismissLoading();

            activity.replaceFragment();

        }catch (Exception e){

            activity.replaceFragment();

        }

    }

    @Click(R.id.number1Button)
    void number1Clicked(){

        anserQuestion(1);

    }

    @Click(R.id.number2Button)
    void number2Clicked(){

        anserQuestion(2);

    }

    @Click(R.id.number3Button)
    void number3Clicked(){

        anserQuestion(3);

    }

    @Click(R.id.number4Button)
    void number4Clicked(){

        anserQuestion(4);

    }

    @Click(R.id.number5Button)
    void number5Clicked(){

        anserQuestion(5);

    }

    @Click(R.id.number6Button)
    void number6Clicked(){

        anserQuestion(6);

    }

    @Click(R.id.number7Button)
    void number7Clicked(){

        anserQuestion(7);

    }

    @Click(R.id.number8Button)
    void number8Clicked(){

        anserQuestion(8);

    }

    @Click(R.id.number9Button)
    void number9Clicked(){

        anserQuestion(9);

    }

    @Click(R.id.number10Button)
    void number10Clicked(){

        anserQuestion(10);

    }


}
