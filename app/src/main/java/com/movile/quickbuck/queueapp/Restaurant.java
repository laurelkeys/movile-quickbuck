package com.movile.quickbuck.queueapp;

/**
 * Created by Felipe on 31/10/2015.
 */
public class Restaurant {
    float accessCode;
    String name;
    String descrition;
    String address;
    int queueSize;

    public Restaurant() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    public float getAccessCode() {
        return accessCode;
    }

    public String getName() {
        return name;
    }

    public String getDescrition() {
        return descrition;
    }

    public String getAddress() {
        return address;
    }

    public Integer getQueueSize() {
        return queueSize;
    }
}
