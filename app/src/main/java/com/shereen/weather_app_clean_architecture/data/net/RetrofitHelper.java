package com.shereen.weather_app_clean_architecture.data.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shereen on 11/8/18
 */

public class RetrofitHelper {

    private static Retrofit retrofit;
    final static String URL = "https://api.openweathermap.org/";//"http://swapi.co/api/";

    public static Retrofit getRetrofit(){
        if(retrofit != null){
            return retrofit;
        }
        retrofit = new Retrofit.Builder()
                //.baseUrl()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
