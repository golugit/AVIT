package com.example.ram2;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ram2.Adapter.ModelAdapter;
import com.example.ram2.interfaces.ApiClient;
import com.example.ram2.interfaces.ApiInterface;
import com.example.ram2.model.Model;
import com.example.ram2.model.Response;
import java.io.InputStream;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<Response> call = apiService.getlist();
        call.enqueue(new Callback<Response>() {
            private final String TAG = MainActivity.class.getSimpleName();

            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<Model> movies = response.body().getData();
                Log.d(TAG, "Number of movies received: " + movies.size());
                final RecyclerView recyclerView = findViewById(R.id.Model_recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new ModelAdapter(movies, R.layout.activity_list_item_model, MainActivity.this));
            }
            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                // Log error here since request failed
                Log.e("mainactivity error", t.toString());
            }
        });

    }
}