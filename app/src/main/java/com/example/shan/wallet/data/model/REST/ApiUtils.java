package com.example.shan.wallet.data.model.REST;

/**
 * Created by shan on 26.08.2017.
 */

public class ApiUtils {

    private static final String BASE_URL = "http://www.dev.pl.hostingasp.pl/api/";

    public static IRetrofitClient getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(IRetrofitClient.class);
    }
}