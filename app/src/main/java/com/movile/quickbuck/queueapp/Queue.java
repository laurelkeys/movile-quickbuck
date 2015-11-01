package com.movile.quickbuck.queueapp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Queue {

    public Integer queueSize;
    public List<User> users = new ArrayList<User>();
    public int getQueueSize(){return queueSize;}
}
