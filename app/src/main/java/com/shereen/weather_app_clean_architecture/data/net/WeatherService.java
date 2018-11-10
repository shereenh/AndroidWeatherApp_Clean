package com.shereen.weather_app_clean_architecture.data.net;

import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shereen on 11/8/18
 */

public interface WeatherService {

    @GET("data/2.5/forecast/daily?q=32789&mode=json&units=metric&cnt=14&appid=f8fdae74c29544baebdb927d392c5538")
    Observable<WeatherEntity> getWeatherEntity();

    @GET("data/2.5/forecast/daily?mode=json&units=metric&cnt=14&appid=f8fdae74c29544baebdb927d392c5538")
    Observable<WeatherEntity> getCityWeatherEntity(@Query("q") String cityName);
}
