package com.example.tmsc.loginapplication.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.kimo.lib.faker.component.text.AddressComponent;
import io.kimo.lib.faker.component.text.LoremComponent;
import io.kimo.lib.faker.component.text.NameComponent;

public class FeedModel {

    private String name;
    private String address;
    private String photoUri;

    private String description;

    private FeedModel(String name, String address, String photoUri) {
        setPhotoUri(photoUri);
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    private void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public static ArrayList<FeedModel> getSamples(Context context, int capacity) {

        ArrayList<FeedModel> items = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {
            NameComponent name = new NameComponent(context);
            AddressComponent address = new AddressComponent(context);

            LoremComponent loremComponent = new LoremComponent(context);
            FeedModel model = new FeedModel(name.fullName(), address.randomText(), "http://i.imgur.com/DvpvklR.png");
            model.setDescription(loremComponent.paragraphs());
            items.add(model);

        }

        return items;
    }

    public static ArrayList<FeedModel> filterByText(List<FeedModel> models, CharSequence text) {

        ArrayList<FeedModel> items = new ArrayList<>();

        for (int i = 0; i < models.size(); i++) {
            if (models.get(i).getName().toLowerCase().contains(text.toString().toLowerCase())) {
                items.add(models.get(i));
            }
        }

        return items;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
