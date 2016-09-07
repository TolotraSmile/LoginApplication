package com.example.tmsc.loginapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tmsc.loginapplication.R;

import org.androidannotations.annotations.EActivity;

/**
 * A login screen that offers login via email/password.
 */

@EActivity(R.layout.activity_login)
public class LoginActivity extends Activity {
    public void clickEvent(View v) {
        Intent intent = new Intent(LoginActivity.this, FeedActivity_.class);
        startActivity(intent);
    }
}

