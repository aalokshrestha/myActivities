package com.usc.myActivities.lab;

import java.util.UUID;

public class Model_MyActivity {

    private UUID mId;

    private String title="";
    private String date="";
    private String destination="";
    private String duration="";
    private String comment="";
    private String location="";
    private String type="";

    public Model_MyActivity(){
        mId = UUID.randomUUID();
    }

    public Model_MyActivity(UUID id) {
        mId = id;
    }

    public Model_MyActivity(String title, String date, String destination, String duration, String comment, String type) {
        this(UUID.randomUUID());
        this.title = title;
        this.date = date;
        this.destination = destination;
        this.duration = duration;
        this.comment = comment;
        this.type = type;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
