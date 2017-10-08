package com.example.shan.wallet;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shan.wallet.Models.User;
import com.example.shan.wallet.data.model.REST.ApiUtils;
import com.example.shan.wallet.data.model.REST.IRetrofitClient;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoggedActivity extends AppCompatActivity {

    SharedPreferences userId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        userId = PreferenceManager.getDefaultSharedPreferences(this);

        //Pobiera ID uzytkownika z SharedPreferences aby moc pobrac jego dane(zapytanie wysylanie po ID do api)
        int id = userId.getInt("id",-1);
        if(id == -1) {
            Toast.makeText(getApplicationContext(), "ERR", Toast.LENGTH_SHORT).show();
        }

        IRetrofitClient api = ApiUtils.getSOService();


        api.getUserByID(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(User userDetails) {

                        String name = userDetails.getName().toString();

                    }
                });
    }
}
