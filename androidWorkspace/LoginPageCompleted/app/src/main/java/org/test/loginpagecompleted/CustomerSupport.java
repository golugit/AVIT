package org.test.loginpagecompleted;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class CustomerSupport extends AppCompatActivity {

TextView email,contactNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_support);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactNo=findViewById(R.id.contactno);

        email=(TextView)findViewById(R.id.email);
        email.setText("Email");
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });



        contactNo.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                startActivity(intent);
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
