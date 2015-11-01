package com.movile.quickbuck.queueapp;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queue {

    @SerializedName("queueSize")
    @Expose
    public Integer queueSize;
    @SerializedName("users")
    @Expose
    public List<User> users = new ArrayList<User>();
    public int getQueueSize(){return queueSize;}
}
