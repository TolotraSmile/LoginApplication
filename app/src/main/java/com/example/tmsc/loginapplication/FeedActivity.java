package com.example.tmsc.loginapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tmsc.loginapplication.Adapters.FeedAdapter;
import com.example.tmsc.loginapplication.Models.FeedModel;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_feed)
public class FeedActivity extends Activity {
    RecyclerView rv;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        rv = (RecyclerView) findViewById(R.id.feed_list);
        init();
    }

    void init() {
        try {
            Log.v("FeedActivity", "Eto aho");
            LinearLayoutManager llm = new LinearLayoutManager(FeedActivity.this);
            rv.setLayoutManager(llm);
            FeedAdapter adapter = new FeedAdapter(FeedModel.getSamples(10));
            rv.setAdapter(adapter);
        } catch (Exception e) {
            Log.v("FeedActivity", e.getMessage());
        }

    }

}
