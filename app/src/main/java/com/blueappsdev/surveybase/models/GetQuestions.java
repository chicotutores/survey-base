package com.blueappsdev.surveybase.models;

import java.util.ArrayList;

/**
 * Created by douglas_nunes on 1/7/17.
 */

public class GetQuestions {

    private ArrayList<Question> data;

    private String errors;

    public ArrayList<Question> getData() {
        return data;
    }

    public void setData(ArrayList<Question> data) {
        this.data = data;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}
