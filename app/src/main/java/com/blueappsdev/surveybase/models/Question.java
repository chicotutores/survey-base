package com.blueappsdev.surveybase.models;

/**
 * Created by douglas_nunes on 1/7/17.
 */

public class Question  implements Comparable<Question>{

    private int id;

    private int type;

    private int order;

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Question o) {
        if (order < o.order){

            return -1;

        }

        return 1;

    }
}
