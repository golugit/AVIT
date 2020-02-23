package org.test.retroexample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.test.retroexample.Interface.ApiInterface;
import org.test.retroexample.Interface.DataApiInterface;
import org.test.retroexample.POJO.DataModel;
import org.test.retroexample.POJO.Datum;
import org.test.retroexample.POJO.HeroModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        /*Retrofit retrofitHero=new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiHero = retrofitHero.create(ApiInterface.class);

        Call<List<HeroModel>> callHero = apiHero.getDataDetails();
        callHero.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                List<HeroModel> heroes=response.body();
                for(HeroModel h:heroes){
                    Log.d("name",h.getName());
                    Log.d("realname",h.getRealname());
                    Log.d("imageurl",h.getImageurl());
                }
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });*/

    Log.i("*****TEST*****","^^^^^");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(DataApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataApiInterface api = retrofit.create(DataApiInterface.class);

        Call<DataModel> call = api.getDataDetails();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel datas=response.body();
                Log.i("p ::",datas.getPage()+datas.getPerPage()
                        +datas.getTotal()+datas.getTotalPages()+"");

                for(Datum h:datas.getData()){
                    Log.d("email:",h.getEmail());
                    Log.d("F NAme:",h.getFirstName());
                    Log.d("L NAme:",h.getLastName());
                }

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                //Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                Log.i("ERRROR","ERRROR");
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
