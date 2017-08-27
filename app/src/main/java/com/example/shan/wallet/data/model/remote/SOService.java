package com.example.shan.wallet.data.model.remote;

/**
 * Created by shan on 26.08.2017.
 */

import com.example.shan.wallet.data.model.SOAnswersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface SOService {

    @GET("user/1")
    Call<SOAnswersResponse> getAnswers();



    //@GET("/answers?order=desc&sort=activity&site=stackoverflow")
    //Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);
}