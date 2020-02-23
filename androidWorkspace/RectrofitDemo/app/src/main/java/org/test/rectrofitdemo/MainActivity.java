package org.test.rectrofitdemo;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.test.rectrofitdemo.API.ApiClient;
import org.test.rectrofitdemo.API.ApiInterface;
import org.test.rectrofitdemo.POJO.TestModel;
import org.test.rectrofitdemo.POJO.TestResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getData().create(ApiInterface.class);

        Call<TestResponse> call = apiService.getData();
        call.enqueue(new Callback<TestResponse>() {
            @Override
            public void onResponse(Call<TestResponse> call, Response<TestResponse> response)

            {
                List<TestModel> movies = response.body().getData();
              Log.d(TAG, "Number of movies received: " + movies.size());
               /*// recyclerView.setAdapter(new ContentAdaptor(movies, R.layout.content_list, getApplicationContext()));
                final RecyclerView recyclerView = findViewById(R.id.recycleview);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));*/
                recyclerView.setAdapter(new ContentAdaptor(movies, R.layout.content_list, getApplicationContext()));

//
            }

            @Override
            public void onFailure(Call<TestResponse> call, Throwable t)
            {
                Log.e(TAG,t.toString());
                Toast.makeText(MainActivity.this, "not", Toast.LENGTH_SHORT).show();

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

