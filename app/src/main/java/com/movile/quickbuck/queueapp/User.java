package com.movile.quickbuck.queueapp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class User {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("username")
        @Expose
        public String username;
}