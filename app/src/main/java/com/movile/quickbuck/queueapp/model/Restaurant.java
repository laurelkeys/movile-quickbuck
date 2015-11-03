package com.movile.quickbuck.queueapp.model;

public class Restaurant {

    public String name;
    public String address;
    public String description;
    public Queue queue;
    public String accessCode;

    public int getQueueSize() {
    	return queue.getQueueSize();
    }

    public String getName() {
    	return name;
    }

    public String getAddress() {
    	return address;
    }

    public String getDescription() {
    	return description;
    }

    public Queue getQueue() {
    	return queue;
    }

    public String getAccessCode() {
    	return accessCode;
    }
}
