package org.test.retroexample.Interface;


import org.test.retroexample.POJO.HeroModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "https://simplifiedcoding.net/demos/" ;

    @GET("marvel")
    Call<List<HeroModel>> getDataDetails();




              //List<HeroModel> heroist=new ArrayList<>();

}
