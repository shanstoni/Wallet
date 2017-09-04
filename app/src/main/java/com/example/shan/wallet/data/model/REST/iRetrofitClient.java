package com.example.shan.wallet.data.model.REST;

/**
 * Created by shan on 26.08.2017.
 */

import com.example.shan.wallet.Models.LoginModelClass;
import com.example.shan.wallet.Models.UserModelClass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface iRetrofitClient {

    @GET("user/{id}")
    Observable<UserModelClass> getUserByID(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @POST("login")
    //@FormUrlEncoded
    Observable<Integer> logIn(@Body LoginModelClass user);




    //@GET("/answers?order=desc&sort=activity&site=stackoverflow")
    //Call<UserModelClass> getAnswers(@Query("tagged") String tags);
}