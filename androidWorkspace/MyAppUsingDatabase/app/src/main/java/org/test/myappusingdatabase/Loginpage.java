package org.test.myappusingdatabase;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.test.myappusingdatabase.api.ApiInterface;
import org.test.myappusingdatabase.api.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Loginpage extends AppCompatActivity {
    EditText email,password;
Button login;
TextView forgot,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        login=findViewById(R.id.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        forgot=findViewById(R.id.forgot);
        register=findViewById(R.id.register);



        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginpage.this,ForgotPage.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Loginpage.this,Registationpage.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals(""))
                {
                    email.setError("Invalid Email");
                }
                else if(password.getText().toString().equals(""))
                {
                    password.setError("Invalid password");
                }
                else
                {

                    validateUser(email.getText().toString(),password.getText().toString());

                    /*Log.i("*****else*****","^^^^^");
                    Boolean status=validateUser(email.getText().toString(),password.getText().toString());
                    if(status){
                        Log.i("*****Main Status*****",String.valueOf(status));
                        Intent intent = new Intent(Loginpage.this,MainActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(Loginpage.this,Loginpage.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Credentials not match",Toast.LENGTH_LONG).show();
                    }*/

                }

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

    private void validateUser(String user, String pass) {
        Log.i("*****validateUser*****","user : "+user+" , pass:"+pass);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("*****retrofit*****","^^^^^");
        ApiInterface api = retrofit.create(ApiInterface.class);
        Log.i("*****api*****","^^^^^");
        Call<LoginResponse> callLogin = api.validateLogin(user,pass);
        Log.i("*****callLogin*****","^^^^^");
        callLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i("*****onResponse*****","^^^^^");
               LoginResponse loginResponse =response.body();
                Log.i("*****loginResponse*****","^^^^^");
                if(Boolean.valueOf(loginResponse.getStatus())){
                                 Intent intent = new Intent(Loginpage.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(Loginpage.this,Loginpage.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Credentials not match",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Login failure",Toast.LENGTH_LONG).show();
            }
        });
    }

}
