package com.movile.quickbuck.queueapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("queue")
    @Expose
    public Queue queue;
    @SerializedName("accessCode")
    @Expose
    public String accessCode;

    public int getQueueSize(){
        return queue.getQueueSize();
    }

    public String getName(){
        return name;
    }
}
