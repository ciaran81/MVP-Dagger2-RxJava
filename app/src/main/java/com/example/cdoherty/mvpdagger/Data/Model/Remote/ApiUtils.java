package com.example.cdoherty.mvpdagger.Data.Model.Remote;

/**
 * Created by cdoherty on 28/03/2018.
 */

public class ApiUtils {
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOService getSOService(){
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
