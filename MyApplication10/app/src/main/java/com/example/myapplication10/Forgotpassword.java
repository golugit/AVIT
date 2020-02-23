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

public class Forgotpassword extends AppCompatActivity {
    private EditText email2;
    private Button   submit2;
    public static Object setOnClickListerner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        Toolbar toolbar = findViewById(R.id.toolbar);
        email2=findViewById(R.id.email2);
        submit2=findViewById(R.id.submit2);
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email2.getText().toString().equals(""))

                {
                    email2.setError("Invalid Email");
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"PAssword  sent sucessfully",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Forgotpassword.this,MainActivity.class);
                    startActivity(i);
                }
            }
        });
        setSupportActionBar(toolbar);
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
