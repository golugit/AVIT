package org.test.retroexample.Interface;

import org.test.retroexample.POJO.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataApiInterface {

    String BASE_URL = "https://reqres.in/api/";
    @GET("users")
    Call<DataModel> getDataDetails();

}
