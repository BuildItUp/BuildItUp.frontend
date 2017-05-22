package com.example.rizalfauzy.builditup.rest;

import com.example.rizalfauzy.builditup.model.user.UserUpdate;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Rizal Fauzy on 5/22/2017.
 */

public interface UserAPIInterface {
    @FormUrlEncoded
    @POST("user/login")
    Call<UserUpdate> userLogin(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("user/register")
    Call<UserUpdate> userRegister(
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email
    );
}
