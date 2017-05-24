package com.example.rizalfauzy.builditup.model.customer;

import android.content.Intent;
import android.widget.Toast;

import com.example.rizalfauzy.builditup.Biodata1Page;
import com.example.rizalfauzy.builditup.RegisterPage;
import com.example.rizalfauzy.builditup.model.user.User;
import com.example.rizalfauzy.builditup.model.user.UserUpdate;
import com.example.rizalfauzy.builditup.rest.APIClient;
import com.example.rizalfauzy.builditup.rest.CustomerAPIInterface;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class Customer {
    @SerializedName("id")
    private int id;
    @SerializedName("user_id")
    private int user_id;
    @SerializedName("city_id")
    private int city_id;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("citizen_id")
    private String citizen_id;
    @SerializedName("photo_path")
    private String photo_path;
    @SerializedName("address")
    private String address;
    @SerializedName("phone_number")
    private String phone_number;
    @SerializedName("email")
    private String email;
    @SerializedName("budget")
    private long budget;

    public Customer() {
    }

    public Customer(int id, String fullname, String citizen_id, String phone_number) {
        this.id = id;
        this.fullname = fullname;
        this.citizen_id = citizen_id;
        this.phone_number = phone_number;
    }

    public Customer(int id, int user_id, int city_id, String fullname, String citizen_id, String photo_path, String address, String phone_number, String email, long budget) {
        this.id = id;
        this.user_id = user_id;
        this.city_id = city_id;
        this.fullname = fullname;
        this.citizen_id = citizen_id;
        this.photo_path = photo_path;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(String citizen_id) {
        this.citizen_id = citizen_id;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }
}
