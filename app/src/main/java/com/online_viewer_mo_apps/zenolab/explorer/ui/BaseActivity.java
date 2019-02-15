package com.online_viewer_mo_apps.zenolab.explorer.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import com.arellomobile.mvp.MvpAppCompatActivity;

@SuppressLint("Registered")
//public abstract class BaseActivity extends AppCompatActivity {
public abstract class BaseActivity  extends MvpAppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
