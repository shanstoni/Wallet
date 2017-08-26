package com.example.shan.wallet.data.model.remote;

/**
 * Created by shan on 26.08.2017.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://www.dev.pl.hostingasp.pl/api/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}