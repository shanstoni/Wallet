package com.example.shan.wallet.data.model.REST;

/**
 * Created by shan on 26.08.2017.
 */

import com.example.shan.wallet.Models.User;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;
import com.example.shan.wallet.Models.Login;
import com.example.shan.wallet.Models.User;

public class RetrofitClient{

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            }
            return retrofit;
    }

    public void getId() {

        //@GET("user/{id}")
       // Observable<User> getUserByID(@Path("id") int id);
    };

    public void postLogin() {

//        @Headers("Content-Type: application/json")
//        @POST("login")
//        //@FormUrlEncoded
//        Observable<Integer> logIn(@Body Login user);

    };

}