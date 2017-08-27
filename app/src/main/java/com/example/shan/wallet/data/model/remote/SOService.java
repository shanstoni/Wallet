package com.example.shan.wallet.data.model.remote;

/**
 * Created by shan on 26.08.2017.
 */

import com.example.shan.wallet.Models.IdModelClass;
import com.example.shan.wallet.Models.LoginModelClass;
import com.example.shan.wallet.Models.UserModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SOService {

    @GET("user/1")
    Call<UserModelClass> getUserByID();

    @POST("login")
    Call<IdModelClass> logIn(@Body LoginModelClass user);




    //@GET("/answers?order=desc&sort=activity&site=stackoverflow")
    //Call<UserModelClass> getAnswers(@Query("tagged") String tags);
}