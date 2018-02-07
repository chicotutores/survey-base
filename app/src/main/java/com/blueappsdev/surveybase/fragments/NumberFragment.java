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
 * Created by douglas_nunes on 1/8/17.
 */

@EFragment(R.layout.fragment_numbers)
public class NumberFragment extends Fragment {

    @ViewById
    CustomTextView titleTextView, quantityTextView;

    QuestionsActivity activity;

    Question question;

    int currentNumber = 0;

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
            params.put("quantity", answer);

            Response response = MakeRequest.post(Constants.url("answerQuestion/"), params);

            activity.dismissLoading();

            activity.replaceFragment();

        }catch (Exception e){

            activity.replaceFragment();

        }

    }

    @Click(R.id.minusButton)
    void minusClicked(){

        if (currentNumber > 0){

            currentNumber--;

            quantityTextView.setText("" + currentNumber);

        }

    }

    @Click(R.id.plusButton)
    void plusClicked(){

        currentNumber++;

        quantityTextView.setText("" + currentNumber);

    }

    @Click(R.id.confirmButton)
    void confirmClicked(){

        anserQuestion(currentNumber);

    }

}
