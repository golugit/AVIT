package org.test.myappusingdatabase.api;

import org.test.myappusingdatabase.api.response.forgot.ForgotResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForgotInterface {

    String BASE_URL="http://192.168.1.36/MyAppUsingDatabase/";

    @GET("forgot.php")

    Call<ForgotResponse> forgotUser(
            @Query("email") String emailId
    );
}
