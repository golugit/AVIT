package org.test.exampleretrofit.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RectroInterface {

    @GET("api/users?page=1")
    Call<RectroInterface> getUserInfo();

}
