package com.example.shan.wallet;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shan.wallet.Models.UserModelClass;
import com.example.shan.wallet.data.model.REST.ApiUtils;
import com.example.shan.wallet.data.model.REST.iRetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoggedActivity extends AppCompatActivity {

    SharedPreferences userId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        userId = PreferenceManager.getDefaultSharedPreferences(this);

        //Pobiera ID uzytkownika z SharedPreferences aby moc pobrac jego dane(zapytanie wysylanie po ID do api)
        int id = userId.getInt("id",-1);
        if(id == -1){
            Toast.makeText(getApplicationContext(), "ERR", Toast.LENGTH_SHORT).show();
        }

                iRetrofitClient api = ApiUtils.getSOService();
                Call<UserModelClass> call = api.getUserByID(id);
                call.enqueue(new Callback<UserModelClass>() {

                    @Override
                    public void onResponse(Call<UserModelClass> call, Response<UserModelClass> response) {
                        if (response.isSuccessful()){
                            String name = response.body().getName().toString();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserModelClass> call, Throwable t) {

                    }
                });


    }
}
