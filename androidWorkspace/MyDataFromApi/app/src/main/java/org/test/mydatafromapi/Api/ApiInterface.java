package org.test.mydatafromapi.Api;

import org.test.mydatafromapi.POJO.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    String BASE_URL = "" ;

    @GET("")
    Call<List<Model>> getDataDetails();

}
