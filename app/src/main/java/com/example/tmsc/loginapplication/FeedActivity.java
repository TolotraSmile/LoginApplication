package com.example.tmsc.loginapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmsc.loginapplication.Adapters.NewFeedAdapter;
import com.example.tmsc.loginapplication.Models.FeedModel;
import com.google.gson.Gson;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

@EActivity(R.layout.activity_feed)
public class FeedActivity extends Activity {

    ListView listView;

    EditText searchView;
    ArrayList<FeedModel> models;

    @AfterViews
    void init() {

        // Construct the data source
        models = FeedModel.getSamples(FeedActivity.this, 20);

        // Create the adapter to convert the array to views
        final NewFeedAdapter adapter = new NewFeedAdapter(this, models);
        listView = (ListView) findViewById(R.id.feed_list);

        // Attach the adapter to a ListView
        if (listView != null) {
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    Gson gson = new Gson();
                    Intent intent = new Intent(FeedActivity.this, FeedDetailsActivity_.class);
                    intent.putExtra("data", gson.toJson(models.get(position)));
                    startActivity(intent);
                }
            });
        }

        adapter.notifyDataSetChanged();
        searchView = (EditText) findViewById(R.id.feed_search);

        if (searchView != null) {
            searchView.clearFocus();
            searchView.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

            searchView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    listView.setAdapter(new NewFeedAdapter(FeedActivity.this, FeedModel.filterByText(models, s)));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    void startActivity(Class<?> context) {
        startActivity(new Intent(FeedActivity.this, context));
    }
}