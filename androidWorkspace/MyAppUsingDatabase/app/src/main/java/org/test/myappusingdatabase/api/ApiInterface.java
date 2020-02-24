package org.test.myappusingdatabase.api;
import org.test.myappusingdatabase.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "http://192.168.43.107/MyAppUsingDatabase/" ;

    @GET("loginApi.php")
    Call<LoginResponse> validateLogin(
            @Query("username") String username,
            @Query("password") String password
    );
}
