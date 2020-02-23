package org.test.rectrofitdemo.API;

import org.test.rectrofitdemo.POJO.TestResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/users?page=1")
    Call<TestResponse> getData();

}
