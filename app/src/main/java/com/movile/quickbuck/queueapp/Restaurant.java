package com.movile.quickbuck.queueapp;

public class Restaurant {

    public String name;
    public String address;
    public String description;
    public Queue queue;
    public String accessCode;

    public int getQueueSize(){
        return queue.getQueueSize();
    }

    public String getName(){
        return name;
    }
}
