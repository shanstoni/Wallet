package com.example.shan.wallet.data.model.REST;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.shan.wallet.LoggedActivity;
import com.example.shan.wallet.MainActivity;
import com.example.shan.wallet.Models.Login;
import com.example.shan.wallet.Models.Token;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by shan on 07.10.2017.
 */

public class RetrofitRequest implements IRetrofitRequest{

    private static IRetrofitClient _api;
    SharedPreferences userId = null;

    public RetrofitRequest() {
        _api = ApiUtils.getSOService();
    }

    public void getUserIdToSharedPref(String login, String password) {

        Login user = new Login(login, password);

        final Subscription id = _api.logIn(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer answer) {
                //API zwraca id uzytkownika na ktorego sie zalogowalismy(id>0), jesli zwroci <0 to logowanie nieudane
                //SharedPreferences - przechowywanie userID otrzymanego z api
                SharedPreferences.Editor editor = userId.edit();
                editor.putInt("id", answer);
                editor.apply();
          }

        });

    }
}
