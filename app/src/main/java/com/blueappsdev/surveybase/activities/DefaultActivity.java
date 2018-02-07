package com.blueappsdev.surveybase.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;

/**
 * Created by douglas_nunes on 1/7/17.
 */

@EActivity
public class DefaultActivity extends AppCompatActivity {

    ProgressDialog loading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupLoadingDialog();
    }

    @UiThread
    void setupLoadingDialog() {
        loading = new ProgressDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        loading.setTitle("");
        loading.setMessage("Carregando");
        loading.setCanceledOnTouchOutside(false);
        loading.setCancelable(false);
    }

    @UiThread
    public void showLoading() {
        loading.show();
    }

    @UiThread
    public void dismissLoading() {
        if (loading.isShowing()) {
            loading.dismiss();
        }
    }

}
