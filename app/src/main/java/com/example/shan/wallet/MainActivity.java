package com.example.shan.wallet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shan.wallet.Models.LoginModelClass;
import com.example.shan.wallet.Models.UserModelClass;
import com.example.shan.wallet.data.model.REST.ApiUtils;
import com.example.shan.wallet.data.model.REST.iRetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    Button ButtonLogin;
    Button ButtonRegister;

    SharedPreferences userId = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nickname  = (EditText) findViewById(R.id.nicknameEditText);
        final EditText password = (EditText) findViewById(R.id.passwordEditText);

        userId = PreferenceManager.getDefaultSharedPreferences(this);

        ButtonLogin = (Button) findViewById(R.id.buttonLogin);
        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iRetrofitClient api = ApiUtils.getSOService();

                LoginModelClass user = new LoginModelClass(nickname.getText().toString(),password.getText().toString());


                final Subscription id = api.logIn(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<Integer>() {
                                       @Override
                                       public void onCompleted() {

                                       }

                                       @Override
                                       public void onError(Throwable e) {

                                       }

                                       @Override
                                       public void onNext(Integer answer) {
                                            //API zwraca id uzytkownika na ktorego sie zalogowalismy(id>0), jesli zwroci <0 to logowanie nieudane
                                            if(answer > 0){

                                            //SharedPreferences - przechowywanie userID otrzymanego z api
                                            SharedPreferences.Editor editor = userId.edit();
                                            editor.putInt("id", answer);
                                            editor.commit();

                                            Intent intent = new Intent(MainActivity.this, LoggedActivity.class);
                                                startActivity(intent);
                                            }else if(answer == -1){
                                                Toast.makeText(getApplicationContext(), "Wrong username!", Toast.LENGTH_SHORT).show();
                                            }else if(answer == -2){
                                                Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                                            }
                              }
                          });
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
