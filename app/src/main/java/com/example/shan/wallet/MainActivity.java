package com.example.shan.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button ButtonLogin;
    Button ButtonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nickname  = (EditText) findViewById(R.id.nicknameEditText);
        final EditText password = (EditText) findViewById(R.id.passwordEditText);

        ButtonLogin = (Button) findViewById(R.id.buttonLogin);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "retrofit", Toast.LENGTH_SHORT).show();
            }
        });

        ButtonRegister = (Button) findViewById(R.id.buttonRegister);
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
