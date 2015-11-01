package com.movile.quickbuck.queueapp;

/**
 * Created by Felipe on 31/10/2015.
 */
public class User {
    private String username;
    private String id;

    public User(String nome, String id){
        username = nome;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public String getId() {
        return id;
    }
}
