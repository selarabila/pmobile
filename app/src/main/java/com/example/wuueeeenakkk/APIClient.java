package com.example.wuueeeenakkk;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;
    static Retrofit getClient(){
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder().baseUrl("https://my-json-server.typicode.com/selarabila/mobile5/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    return retrofit;
    }
}