package com.example.shan.wallet.data.model.REST;

/**
 * Created by shan on 26.08.2017.
 */

import com.example.shan.wallet.Models.Login;
import com.example.shan.wallet.Models.User;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface IRetrofitClient {

    @GET("user/{id}")
    Observable<User> getUserByID(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("login")
    Observable<Integer> logIn(@Body Login user);

}