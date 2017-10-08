package com.example.shan.wallet.data.model.REST;

import com.example.shan.wallet.Models.Token;

/**
 * Created by shan on 07.10.2017.
 */

public interface IRetrofitRequest {

    void getUserIdToSharedPref(String login, String password);

}
