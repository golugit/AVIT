package com.avinformationtechnology.retrodemo.api;

import com.avinformationtechnology.retrodemo.Mod.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("api/users?page=1")
    Call<UserResponse> getUserInfo();
}
