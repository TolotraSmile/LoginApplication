package com.example.tmsc.loginapplication.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmsc on 17/08/16.
 */
public class FeedModel {

    private String name;
    private String photo;

    FeedModel(String name, String photo) {
        this.setName(name);
        this.setPhoto(photo);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public static List<FeedModel> getSamples(int capacity) {
        List<FeedModel> items = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            items.add(new FeedModel("Name : " + i, "Age : " + i));
        }

        return items;
    }

}
