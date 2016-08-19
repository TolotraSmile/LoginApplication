package com.example.tmsc.loginapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmsc.loginapplication.Models.FeedModel;
import com.example.tmsc.loginapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by tmsc on 18/08/16.
 */
public class NewFeedAdapter extends ArrayAdapter<FeedModel> {

    Context context;

    public NewFeedAdapter(Context context, ArrayList<FeedModel> users) {
        super(context, 0, users);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        FeedModel user = getItem(position);
        FeedViewHolder holder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_feed, parent, false);

            holder = new FeedViewHolder();
            // Lookup view for data population
            holder.tvName = (TextView) convertView.findViewById(R.id.feed_person_name);
            holder.tvHome = (TextView) convertView.findViewById(R.id.feed_person_age);
            holder.avatar = (CircleImageView) convertView.findViewById(R.id.feed_person_photo);

            convertView.setTag(holder);
        }
        else {
            holder = (FeedViewHolder) convertView.getTag();
        }

        // Populate the data into the template view using the data object
        holder.tvName.setText(user.getName());
        holder.tvHome.setText(user.getAddress());

        //feed_person_photo
        Picasso.with(context).load(user.getPhotoUri()).into(holder.avatar);

        // Return the completed view to render on screen
        return convertView;
    }

    public static class FeedViewHolder {
        public TextView tvName;
        public TextView tvHome;
        public CircleImageView avatar;

    }
}
