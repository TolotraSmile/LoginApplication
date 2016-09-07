package com.example.tmsc.loginapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.tmsc.loginapplication.models.FeedModel;
import com.example.tmsc.loginapplication.R;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;


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
        } else {
            throw new NullPointerException("Data in feed is Null");
        }
    }

    private FeedModel model;

    public void setModel(FeedModel model) {
        if (model != null) {
            this.model = model;
        }
    }

    public void setModel(String json) {
        try {
            setModel(new Gson().fromJson(json, FeedModel.class));
        } catch (Exception e) {
            Log.v("FeedDetailsActivity", e.getMessage());
        }
    }
}