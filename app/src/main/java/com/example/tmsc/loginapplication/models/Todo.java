package com.example.tmsc.loginapplication.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "todo")
public class Todo {

    @DatabaseField(generatedId = true)
    private Long id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String description;

    @DatabaseField
    private Date dateCreated;

    @DatabaseField
    private Date dueDate;

    public Todo() {

    }

    public Todo(String title, String description, Date dateCreated, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return id + " : " + title + " - " + description + " at " + dueDate.toString();
    }
}