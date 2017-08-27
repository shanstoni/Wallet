package com.example.shan.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shan.wallet.Models.IdModelClass;
import com.example.shan.wallet.Models.LoginModelClass;
import com.example.shan.wallet.Models.UserModelClass;
import com.example.shan.wallet.data.model.remote.ApiUtils;
import com.example.shan.wallet.data.model.remote.SOService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

                SOService api = ApiUtils.getSOService();

                LoginModelClass user = new LoginModelClass("test","test");

                Call<IdModelClass> call = api.logIn(user);
                call.enqueue(new Callback<IdModelClass>() {
                    @Override
                    public void onResponse(Call<IdModelClass> call, Response<IdModelClass> response) {
                        int id = response.body().getId();
                    }

                    @Override
                    public void onFailure(Call<IdModelClass> call, Throwable t) {

                        Log.e("test",call.toString());
                        Log.e("test",t.toString());

                    }
                });

//                Call<UserModelClass> call = api.getUserByID();
//                call.enqueue(new Callback<UserModelClass>() {
//
//                    @Override
//                    public void onResponse(Call<UserModelClass> call, Response<UserModelClass> response) {
//                        if (response.isSuccessful()){
//
//                            String name = response.body().getName().toString();
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<UserModelClass> call, Throwable t) {
//
//                    }
//                });

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
