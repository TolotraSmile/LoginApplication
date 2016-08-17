package com.example.tmsc.loginapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    // Go to the login activity
    public void clickEvent(View v) {
        Intent intent = new Intent(MainActivity.this, LoginActivity_.class);
        startActivity(intent);
    }
}
