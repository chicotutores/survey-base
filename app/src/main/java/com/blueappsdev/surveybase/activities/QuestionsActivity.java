package com.blueappsdev.surveybase.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import com.blueappsdev.surveybase.R;
import com.blueappsdev.surveybase.fragments.NotesFragment_;
import com.blueappsdev.surveybase.fragments.NumberFragment_;
import com.blueappsdev.surveybase.fragments.TextFragment_;
import com.blueappsdev.surveybase.fragments.ThankYouFragment_;
import com.blueappsdev.surveybase.fragments.YesNoFragment_;
import com.blueappsdev.surveybase.models.CreateUser;
import com.blueappsdev.surveybase.models.GetQuestions;
import com.blueappsdev.surveybase.models.Question;
import com.blueappsdev.surveybase.utils.Constants;
import com.blueappsdev.surveybase.utils.MakeRequest;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Response;
import st.lowlevel.storo.Storo;

/**
 * Created by douglas_nunes on 1/6/17.
 */


@EActivity(R.layout.activity_questions)
public class QuestionsActivity extends DefaultActivity{

    @ViewById
    LinearLayout mainLayout;

    Gson gson = new Gson();

    GetQuestions questions;

    int currentQuestionIndex = -1;

    public Question currentQuestion;

    public int clientId;

    FragmentTransaction fragmentTransaction;

    Timer inactivityTimer = new Timer();

    @AfterViews
    void afterViews(){

        this.showLoading();

        inactivityTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                returnToIntro();
            }
        }, 120000);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);

        if (Storo.contains(Constants.USER_KEY)){

            CreateUser client = Storo.get(Constants.USER_KEY, CreateUser.class).execute();

            clientId = client.getClientId();

        }else{

            clientId = 9;

        }

        getQuestions();

    }

    @Click(R.id.mainLayout)
    void mainLayoutClicked(){

        inactivityTimer.cancel();

        inactivityTimer = new Timer();

        inactivityTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                returnToIntro();
            }
        }, 120000);

    }

    @Background
    void getQuestions(){

        try{

            HashMap<String, String> params = new HashMap<>();

            Response response = MakeRequest.get(Constants.url("getQuestions"), params);

            this.dismissLoading();

            if (response.isSuccessful()){

                questions = gson.fromJson(response.body().string(), GetQuestions.class);

                Collections.sort(questions.getData(), new Comparator<Question>() {
                    @Override
                    public int compare(Question question1, Question question2) {
                        return question1.compareTo(question2);
                    }
                });

                replaceFragment();

            }else{

                returnToIntro();

            }

        }catch (Exception e){

            returnToIntro();

        }

    }

    public void returnToIntro(){

        IntroActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK).start();

    }

    public void replaceFragment(){

        if(currentQuestionIndex == questions.getData().size() - 1){

            ThankYouFragment_ thankYouFragment = new ThankYouFragment_();

            fragmentTransaction.replace(R.id.questionFragmentContainer, thankYouFragment, "THANK_YOU").commit();

            return;

        }

        currentQuestionIndex++;

        currentQuestion = questions.getData().get(currentQuestionIndex);

        if (currentQuestionIndex == 0){

            YesNoFragment_ fragment = new YesNoFragment_();

            getSupportFragmentManager().beginTransaction().add(R.id.questionFragmentContainer, fragment, "YES_NO").commit();

        }else{

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);

            switch (currentQuestion.getType()){

                case 0:

                    YesNoFragment_ yesNoFragment = new YesNoFragment_();

                    fragmentTransaction.replace(R.id.questionFragmentContainer, yesNoFragment, "YES_NO").commit();

                    break;

                case 1:

                    NotesFragment_ notesFragment = new NotesFragment_();

                    fragmentTransaction.replace(R.id.questionFragmentContainer, notesFragment, "NOTES").commit();

                    break;

                case 2:

                    TextFragment_ textFragment = new TextFragment_();

                    fragmentTransaction.replace(R.id.questionFragmentContainer, textFragment, "TEXT").commit();

                    break;

                case 3:

                    NumberFragment_ numberFragment = new NumberFragment_();

                    fragmentTransaction.replace(R.id.questionFragmentContainer, numberFragment, "NUMBER").commit();

                    break;

            }

        }

    }

}
