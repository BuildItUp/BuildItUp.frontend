package com.example.rizalfauzy.builditup.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class UserQuery {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<User> listUser;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
