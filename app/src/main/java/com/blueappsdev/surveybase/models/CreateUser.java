package com.blueappsdev.surveybase.models;

import java.io.Serializable;

/**
 * Created by douglas_nunes on 1/7/17.
 */

public class CreateUser implements Serializable {

    private String data;

    private int clientId;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
