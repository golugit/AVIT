package com.example.ram2.interfaces;

import com.example.ram2.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/users?page=1")
    Call<Response> getlist();

}
