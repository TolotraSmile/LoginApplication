package com.example.tmsc.loginapplication;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    // Go to the login activity
    public void clickEvent(View v) {
        Intent intent = new Intent(MainActivity.this, FeedActivity_.class);
        startActivity(intent);
    }
}
