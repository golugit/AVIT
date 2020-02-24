package org.test.myappusingdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.test.myappusingdatabase.api.RegisterInterface;
import org.test.myappusingdatabase.api.response.registation.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterPage extends AppCompatActivity {

    EditText firstName,middleName,lastName,userName,email,password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstName=findViewById(R.id.firstname);
        middleName=findViewById(R.id.middlename);
        lastName=findViewById(R.id.lastname);
        userName=findViewById(R.id.user);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstName.getText().toString().isEmpty()){
                    firstName.setError("Invalid name");
                }
                else if(middleName.getText().toString().isEmpty()){
                    middleName.setError("Invalid name");
                }
                else if(lastName.getText().toString().isEmpty()){
                    lastName.setError("Invalid name");
                }
                else if(userName.getText().toString().isEmpty()){
                    userName.setError("Invalid name");
                }
                else if(email.getText().toString().isEmpty()){
                    email.setError("Invalid email");
                }
                else if(password.getText().toString().isEmpty()){
                    password.setError("Invalid password");
                }
                else {
                    Log.i("*****Else*****","^^^^^");
                    String f_name=firstName.getText().toString().trim().toLowerCase();
                    String m_name=middleName.getText().toString().trim().toLowerCase();
                    String l_name=lastName.getText().toString().trim().toLowerCase();
                    String u_name=userName.getText().toString().trim().toLowerCase();
                    String e_mail=email.getText().toString().trim().toLowerCase();
                    String pass=password.getText().toString().trim().toLowerCase();
                    Toast.makeText(getApplicationContext(),"Register Succeffully...", Toast.LENGTH_LONG).show();
                    registerUser(f_name,m_name,l_name,u_name,e_mail,pass);
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

    private void registerUser(String f_name, String m_name, String l_name, String u_name, String e_mail, String pass) {
        Log.i("*****registerUser*****","^^^^^");
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RegisterInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RegisterInterface api = retrofit.create(RegisterInterface.class);

        Call<RegisterResponse> callRegister = api.registerUser(f_name,/*m_name,*/l_name,u_name,e_mail,pass);

        callRegister.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.i("*****onResponse*****","^^^^^");
                RegisterResponse registerResponse =response.body();

                if(registerResponse.isStatus()){
                    Log.i("*****onResponse*****","^^^isStatus : true^^");
                    Intent intent = new Intent(RegisterPage.this,Loginpage.class);
                    startActivity(intent);
                }else{
                    Log.i("*****onResponse*****","^^^isStatus : False^^");
                    Toast.makeText(getApplicationContext(),"Registration Failure",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterPage.this,RegisterPage.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.i("*****onResponse*****","^^^onFailure^^");
                Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();
            }
        });
    }


}
