package com.example.myapplication10;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
private EditText firstname,middlename,lastname;
private EditText email1,confirmemail,password,confirmpassword;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        firstname=findViewById(R.id.firstname);
        middlename=findViewById(R.id.middlename);
        lastname=findViewById(R.id.lastname);
        email1=findViewById(R.id.email1);
        confirmemail=findViewById(R.id.confirmemail);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmpassword);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(firstname.getText().toString().equals(""))
                {

                    email1.setError("In valid first name");
                }
                else if(middlename.getText().toString().equals(""))
                {
                    middlename.setError("In valid middle name");
                }
                else if(lastname.getText().toString().equals(""))
                {
                    lastname.setError("In valid middle name");
                }
                else if(email1.getText().toString().equals(""))
                {
                    email1.setError("In valid email");
                }
                else if(!confirmemail.getText().toString().equals(email1.getText().toString()))
                {
                    confirmemail.setError("In valid confirm email");
                }
                else if(password.getText().toString().equals(""))
                {
                    password.setError("In valid password");
                }
                else if(!confirmpassword.getText().toString().equals(password.getText().toString()))
                {
                    confirmpassword.setError("In valid confirm password");
                }
                else

                {
                    Toast.makeText(Register.this, "Register Sucessfully", Toast.LENGTH_SHORT).show();

                    Intent i=new Intent(Register.this,MainActivity.class);
                    startActivity(i);
                }


            }
        });
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                

            }
        });

    }

}