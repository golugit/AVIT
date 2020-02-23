package org.test.mycalsi;

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
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input1,input2;
    Button addition,subtraction,multiplication,division;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);

        addition=findViewById(R.id.addbtn);
        subtraction=findViewById(R.id.subbtn);
        multiplication=findViewById(R.id.mulbtn);
        division=findViewById(R.id.divbtn);

        result=findViewById(R.id.result);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(input1.getText().toString());
                int number2=Integer.parseInt(input2.getText().toString());
                int sum = number1+number2;
                result.setText("Answer:" +String.valueOf(sum));

            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(input1.getText().toString());
                int number2=Integer.parseInt(input2.getText().toString());
                int sub = number1-number2;
                result.setText("Answer:" +String.valueOf(sub));

            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(input1.getText().toString());
                int number2=Integer.parseInt(input2.getText().toString());
                int mul = number1*number2;
                result.setText("Answer:" +String.valueOf(mul));

            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1=Integer.parseInt(input1.getText().toString());
                float number2=Integer.parseInt(input2.getText().toString());
                float div = number1/number2;
                result.setText("Answer:" +String.valueOf(div));

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
