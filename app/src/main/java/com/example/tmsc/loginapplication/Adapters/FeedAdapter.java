package com.example.tmsc.loginapplication.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmsc.loginapplication.Models.FeedModel;
import com.example.tmsc.loginapplication.R;

import java.util.List;


public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {


    List<FeedModel> feedModels;

    public FeedAdapter(List<FeedModel> models) {
        this.feedModels = models;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed, parent, false);
        return new FeedViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        holder.personName.setText(feedModels.get(position).getName());
        holder.personAge.setText(feedModels.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return feedModels.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        FeedViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.feed_item);
            personName = (TextView) itemView.findViewById(R.id.feed_person_name);
            personAge = (TextView) itemView.findViewById(R.id.feed_person_age);
            personPhoto = (ImageView) itemView.findViewById(R.id.feed_person_photo);
        }
    }

}
