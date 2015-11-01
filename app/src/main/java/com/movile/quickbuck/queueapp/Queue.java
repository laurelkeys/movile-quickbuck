package com.movile.quickbuck.queueapp;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Felipe on 31/10/2015.
 */
public class Queue {
    private Integer queueSize = 0;
    private List<User> queue;
    public Integer getQueueSize() {
        return queueSize;
    }

    public Queue(Integer size, List<User> fila){
        queueSize = size;
        queue = fila;
    }
    public void addUser(User user) {
        queue.add(user);
        ++queueSize;
    }
    public void removeUser(User user) {
        queue.remove(user);
        --queueSize;
    }
}