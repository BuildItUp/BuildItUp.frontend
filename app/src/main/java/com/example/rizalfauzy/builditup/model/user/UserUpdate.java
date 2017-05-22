package com.example.rizalfauzy.builditup.model.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class UserUpdate {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private User user;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
