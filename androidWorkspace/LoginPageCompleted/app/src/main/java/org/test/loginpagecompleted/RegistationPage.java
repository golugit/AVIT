package org.test.loginpagecompleted;

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

public class RegistationPage extends AppCompatActivity {
    EditText firstName,middleName,surname,email,confirmEmail,password,confirmPassword;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstName=findViewById(R.id.firstname);
        middleName=findViewById(R.id.middlename);
        surname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        confirmEmail=findViewById(R.id.confirmemail);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (firstName.getText().toString().equals("")){
                    firstName.setError("Invalid Name");
                }
                else if (middleName.getText().toString().equals("")){
                    middleName.setError("Invalid Name");
                }
                else if (surname.getText().toString().equals("")){
                    surname.setError("Invalid Name");
                }
                else if (email.getText().toString().equals("")){
                    email.setError("Invalid email");
                }
                else if (confirmEmail.getText().toString().equals("")){
                    confirmEmail.setError("Invalid email");
                }
                else if (password.getText().toString().equals("")){
                    password.setError("Invalid password");
                }
                else if (confirmPassword.getText().toString().equals("")){
                    confirmPassword.setError("Invalid password");
                }
                else {
                    Toast.makeText(RegistationPage.this,"successfully registered",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistationPage.this,MainActivity.class);
                    startActivity(intent);
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

}
