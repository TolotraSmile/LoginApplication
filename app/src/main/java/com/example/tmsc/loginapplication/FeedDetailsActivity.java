package com.example.tmsc.loginapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmsc.loginapplication.Models.FeedModel;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.res.TextRes;


@EActivity(R.layout.activity_feed_details)
public class FeedDetailsActivity extends AppCompatActivity {

    @Extra("data")
    String data;

    @AfterViews
    void init() {
        setModel(data);
        if (data != null) {
            TextView title = (TextView) findViewById(R.id.feed_details_title);
            title.setText(this.model.getName());
            TextView subtitle = (TextView) findViewById(R.id.feed_details_content);
            subtitle.setText(this.model.getDescription());
        }
    }

    private FeedModel model;

    public void setModel(FeedModel model) {
        this.model = model;
    }

    public void setModel(String json) {
        try {
            //Toast.makeText(this, json, Toast.LENGTH_SHORT).show();
            this.model = new Gson().fromJson(json, FeedModel.class);
        } catch (Exception e) {
            Log.v("FeedDetailsActivity", e.getMessage());
        }
    }
}
