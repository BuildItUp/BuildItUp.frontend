package com.example.rizalfauzy.builditup.model.customer;

import com.example.rizalfauzy.builditup.model.customer.Customer;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class CustomerUpdate {
    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
