package com.example.irfanfahmiwijaya.fixtubes.Adapter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irfanfahmiwijaya on 12/04/2018.
 */

public class ApiClient {
    public static final String URL      = "http://192.168.1.14/imageuploadtest/";
    public static Retrofit RETROFIT     = null;

    public static Retrofit getClient(){
        if(RETROFIT==null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .build();
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return RETROFIT;
    }
}
