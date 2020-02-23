package org.test.exampleretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.test.exampleretrofit.API.APIClient;
import org.test.exampleretrofit.API.RectroInterface;
import org.test.exampleretrofit.Pojo.TestMode;
import org.test.exampleretrofit.Pojo.TestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIClient ApiClient;
    private static final String TAG = MainActivity.class.getSimpleName();
    private Call<TestResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RectroInterface apiService =
                ApiClient.getClient().create(RectroInterface.class);

        //Call<TestResponse> call = apiService.getUserInfo();

        call.enqueue(new Callback<TestResponse>() {
            @Override
            public void onResponse(Call<TestResponse> call, Response<TestResponse> response)

            {
                List<TestMode> movies = response.body().getData();
                Log.d(TAG, "Number of movies received: " + movies.size());

//
            }

            @Override
            public void onFailure(Call<TestResponse> call, Throwable t)
            {
                Log.e(TAG,t.toString());
                Toast.makeText(MainActivity.this, "not", Toast.LENGTH_SHORT).show();

            }
        });



    }

    }




