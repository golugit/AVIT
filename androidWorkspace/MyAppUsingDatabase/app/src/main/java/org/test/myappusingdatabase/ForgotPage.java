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

import org.test.myappusingdatabase.api.ApiInterface;
import org.test.myappusingdatabase.api.ForgotInterface;
import org.test.myappusingdatabase.api.response.forgot.ForgotResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForgotPage extends AppCompatActivity {
    EditText email;
    Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        email=findViewById(R.id.email);
        submit=findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("")){
                    email.setError("Invalid email");
                }
               else {


                  /*  Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    String aEmailList[] = { "hemangi@2020.com","hemangi@2021.com" };
                    String aEmailCCList[] = { "hemangi@2022.com","hemangi@2023.com"};
                    String aEmailBCCList[] = { "hemangi@2024.com" };
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My subject");
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "My message body.");
                    startActivity(emailIntent);
                    //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                   */

                    forgotuser(email.getText().toString());

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

    private void forgotuser(String emailId) {
        Log.i("****forgotUser****","email:: : "+emailId);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Log.i("***retrofit***","^^^");
        ForgotInterface api = retrofit.create(ForgotInterface.class);
        Log.i("****api*****","^^^^^");
        Call<ForgotResponse> callForgot = api.forgotUser(emailId);
        Log.i("****callForgot****","^^");
        callForgot.enqueue(new Callback<ForgotResponse>() {
            @Override

            public void onResponse(Call<ForgotResponse> call, Response<ForgotResponse> response) {
                Log.i("***onResponse**","^^");
                ForgotResponse forgotResponse = response.body();
                if(forgotResponse.isStatus()){

                    Log.i("**REsponseIfCondition**","^^");

                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    String aEmailList[] = { "hemangi@2020.com","hemangi@2021.com" };
                    String aEmailCCList[] = { "hemangi@2022.com","hemangi@2023.com"};
                    String aEmailBCCList[] = { "hemangi@2024.com" };
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My subject");
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "My message body.");
                    startActivity(emailIntent);
                    //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();


                }
                else{
                    Log.i("**elseCondition*","^^");
                    Intent intent = new Intent(ForgotPage.this,ForgotPage.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Credentials not match",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<ForgotResponse> call, Throwable t) {
                Log.i("**onfailure**","^^");
                Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();


            }
        });


    }


}
