package com.example.shan.wallet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shan.wallet.Misc.BaseActivity;
import com.example.shan.wallet.data.model.REST.RetrofitRequest;

public class MainActivity extends BaseActivity{

    SharedPreferences userId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        final EditText nickname  = (EditText) findViewById(R.id.nicknameEditText);
        final EditText password = (EditText) findViewById(R.id.passwordEditText);


        userId = PreferenceManager.getDefaultSharedPreferences(this);

            final Button ButtonLogin = (Button) findViewById(R.id.buttonLogin);
            ButtonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String StrNickname = nickname.getText().toString();
                    final String StrPassword = password.getText().toString();

                    if((TextUtils.isEmpty(StrNickname)) || (TextUtils.isEmpty(StrPassword))) {
                        if(TextUtils.isEmpty(StrNickname)) {
                            nickname.setError("This field cannot be empty");

                        }
                        if(TextUtils.isEmpty(StrPassword)) {
                            password.setError("This field cannot be empty");
                        }
                       // return;
                    }else{



                        RetrofitRequest retrofitRequest = new RetrofitRequest();
                        retrofitRequest.getUserIdToSharedPref(StrNickname,StrPassword);

                        userId = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                        int currentUserId = userId.getInt("id",-1);

                        if (currentUserId > 0) {
                            Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong credentials", Toast.LENGTH_SHORT).show();
                        }

                }
            }
          }
        );

        final Button ButtonRegister = (Button) findViewById(R.id.buttonRegister);
        ButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
