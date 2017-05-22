package com.example.rizalfauzy.builditup.model.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class User {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("password_hash")
    private String password_hash;
    @SerializedName("password_reset_token")
    private String password_reset_token;
    @SerializedName("access_token")
    private String access_token;
    @SerializedName("email")
    private String email;
    @SerializedName("pin")
    private int pin;
    @SerializedName("auth_key")
    private String auth_key;
    @SerializedName("login_as")
    private String login_as;
    @SerializedName("status")
    private int status;
    @SerializedName("created_at")
    private int created_at;
    @SerializedName("updated_at")
    private int updated_at;

    public User() {
    }

    public User(String username, String password_hash, String email) {
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
    }

    public User(int id, String username, String password_hash, String password_reset_token, String access_token, String email, int pin, String auth_key, String login_as, int status, int created_at, int updated_at) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
        this.password_reset_token = password_reset_token;
        this.access_token = access_token;
        this.email = email;
        this.pin = pin;
        this.auth_key = auth_key;
        this.login_as = login_as;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getPassword_reset_token() {
        return password_reset_token;
    }

    public void setPassword_reset_token(String password_reset_token) {
        this.password_reset_token = password_reset_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getLogin_as() {
        return login_as;
    }

    public void setLogin_as(String login_as) {
        this.login_as = login_as;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }
}
