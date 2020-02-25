package org.test.myappusingdatabase.api;

import org.test.myappusingdatabase.api.response.registation.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RegisterInterface {

    String BASE_URL = "http://192.168.1.36/MyAppUsingDatabase/";

    @GET("registationApi.php")
    Call<RegisterResponse> registerUser(
            @Query("firstname") String f_name,
          //  @Query("password") String m_name,
            @Query("lastname") String l_name,
            @Query("username") String u_name,
            @Query("email") String e_mail,
            @Query("password") String pass
    );
}
