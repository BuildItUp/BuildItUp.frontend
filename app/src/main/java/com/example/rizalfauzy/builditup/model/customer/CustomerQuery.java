package com.example.rizalfauzy.builditup.model.customer;

import com.example.rizalfauzy.builditup.model.customer.Customer;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public class CustomerQuery {

    public class UserQuery {
        @SerializedName("status")
        private String status;
        @SerializedName("message")
        private String message;
        @SerializedName("data")
        private List<Customer> listCustomer;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<Customer> getListCustomer() {
            return listCustomer;
        }

        public void setListCustomer(List<Customer> listCustomer) {
            this.listCustomer = listCustomer;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
