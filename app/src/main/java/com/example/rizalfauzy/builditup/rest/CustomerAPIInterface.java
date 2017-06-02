package com.example.rizalfauzy.builditup.rest;

import com.example.rizalfauzy.builditup.model.customer.CustomerUpdate;
import com.example.rizalfauzy.builditup.model.user.UserUpdate;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public interface CustomerAPIInterface {
    @FormUrlEncoded
    @POST("customer/register")
    Call<CustomerUpdate> customerRegister(
            @Field("user_id") int user_id,
            @Field("fullname") String fullname,
            @Field("citizen_id") String citizen_id,
            @Field("phone_number") String phone_number
    );

    @GET("customer/get-user")
    Call<UserUpdate> customerGetUser(
            @Query("id") int id
    );
}
