package com.example.totalsum;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity {
   EditText productEditText,priceEditText,quantityEditText;
      TextView resultTextView;
   Button totalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productEditText=(EditText)findViewById(R.id.product);
        priceEditText=(EditText)findViewById(R.id.price);
        quantityEditText=(EditText)findViewById(R.id.quantity);
        totalButton=(Button)findViewById(R.id.total);

        resultTextView=(TextView) findViewById(R.id.result);

        totalButton.setOnClickListener(new View.OnClickListener() {
            private CollationElementIterator result;

            @Override
            public void onClick(View v) {

                /*int p = Integer.parseInt(price.getText().toString());
                int q = Integer.parseInt(price.getText().toString());
                int sum = p*q;*/

              String price=priceEditText.getText().toString();
                String quantity=quantityEditText.getText().toString();

               String  result= String.valueOf(Integer.parseInt(price)*Integer.parseInt(quantity));

                Intent intent = new Intent(MainActivity.this,Total.class);

                intent.putExtra("priceI",price);
                intent.putExtra("quantityI",quantity);
                intent.putExtra("totalResult",result);
                startActivity(intent);

              /* int a,b,c;
                a=Integer.parseInt(priceEditText.getText().toString());
                b=Integer.parseInt(quantityEditText.getText().toString());
                c=a*b;
               result.setText(Integer.toString(c));
               Toast.makeText(MainActivity.this, Integer.toString(c),Toast.LENGTH_LONG).show();*/



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
