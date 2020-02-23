package org.test.myappusingdatabase;

import android.app.ProgressDialog;
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
import android.widget.Toast;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registationpage extends AppCompatActivity {
    Button submit;
    EditText firstname,middlename,lastname,email,password,confirmedpassword;
    private ProgressDialog pDialog;

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String API_KEY = "";
     Boolean status=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registationpage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        firstname=findViewById(R.id.firstname);
        middlename=findViewById(R.id.middlename);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmedpassword=findViewById(R.id.confirmPassword);
        submit=findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firstname.getText().toString().equals("")){
                    firstname.setError("Invalid Name");
                }
                else if (middlename.getText().toString().equals("")){
                    middlename.setError("Invalid Name");
                }
                else if (lastname.getText().toString().equals("")){
                    lastname.setError("Invalid Name");
                }
                else if (email.getText().toString().equals("")){
                    email.setError("Invalid email");
                }
                else if (password.getText().toString().equals("")){
                    password.setError("Invalid password");
                }
                else if (confirmedpassword.getText().toString().equals("")){
                    confirmedpassword.setError("Invalid password");
                }
                else {

                    Boolean status=validateUser(firstname.getText().toString(),middlename.getText().toString(),lastname.getText().toString(),email.getText().toString(),password.getText().toString(),confirmedpassword.getText().toString());
                    if(status){
                        // go to next activity

                        Toast.makeText(Registationpage.this,"Successfully Register...",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registationpage.this,Loginpage.class);
                        startActivity(intent);

                    }else{
                        // display toast username and pass not match
                        Toast.makeText(Registationpage.this," Registation Failed..Please try again...",Toast.LENGTH_SHORT).show();


                    }

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

    private Boolean validateUser(String f_name, String m_name, String l_name, String emailid, String pass, String c_pass) {
        Log.i("*****validateUser*****","^^^^^validateUser");

        return status;
    }

}
