package com.shereen.weather_app_clean_architecture.data.net;

/**
 * Created by shereen on 11/8/18
 */

public class ServiceGenerator {

    private static WeatherService weatherService;

    public static WeatherService getWeatherService(){
        if(weatherService==null){
            weatherService = RetrofitHelper.getRetrofit().create(WeatherService.class);
        }
        return weatherService;
    }
}
