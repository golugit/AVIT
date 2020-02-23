package com.example.totalsum;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.totalsum.R.id.quantity;
import static com.example.totalsum.R.id.result;

public class Total extends AppCompatActivity {
TextView result;
TextView priceInput,quntityInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result=findViewById(R.id.result);
        priceInput=(TextView) findViewById(R.id.input1);
        quntityInput=(TextView) findViewById(R.id.input2);

        priceInput.setText(getIntent().getStringExtra("priceI"));
        quntityInput.setText(getIntent().getStringExtra("quantityI"));
        result.setText(getIntent().getStringExtra("totalResult"));






        //Toast.makeText(Total.this, Integer.toString(),Toast.LENGTH_LONG).show();

        /*int res =Integer.parseInt(priceInput.getText().toString())*Integer.parseInt(quntityInput.getText().toString());
        result.setText(res);*/

        /*String toast1="price : "+ getIntent().getStringExtra("priceI") + "::: Quan : "
                + getIntent().getStringExtra("quantityI");

        Toast.makeText(Total.this, toast1,Toast.LENGTH_LONG).show();
        int res=Integer.parseInt(String.valueOf(priceInput.getText()))*Integer.parseInt(String.valueOf(quntityInput.getText()));
        System.out.println("Res: "+res);
        result.setText(res);*/
        //result=input1*input2;

        /*EditText a = input1;
        EditText b=input2;
        Integer.parseInt(input1.getText().toString());
        Integer.parseInt(input2.getText().toString());
        int c = a * b;
        result.setText(Integer.toString(c));
*/
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
