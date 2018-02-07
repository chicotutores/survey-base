package com.blueappsdev.surveybase.utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by douglas_nunes on 1/7/17.
 */

public class MakeRequest {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static Response get(String url, HashMap<String,String> parameters) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Iterator<String> it = parameters.keySet().iterator();
        url += url.endsWith("?") ? "" : "?";

        int i=0;
        while (it.hasNext()) {
            String chave = it.next();

            if (i == 0) {
                url = url + chave+"="+parameters.get(chave);
            } else {
                url = url +"&"+chave+"="+parameters.get(chave);
            }

            i++;
        }

        Request.Builder builder = new Request.Builder();

        Request request = builder.url(url).build();
        return client.newCall(request).execute();
    }

    public static Response post(String url, Map<String,Object> paramValor) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Gson gson = new Gson();
        String json = gson.toJson(paramValor);

        Request request = new Request.Builder()
                .addHeader("Content-Type","application/json")
                .url(url)
                .post(RequestBody.create(JSON, json))
                .build();
        Response response = client.newCall(request).execute();

        return response;
    }


}
