package com.shereen.weather_app_clean_architecture.data.repository.datasource;

//import com.shereen.weather_clean.data.cache.WeatherCache;
//import com.shereen.weather_clean.data.entity.WeatherEntity;
//import com.shereen.weather_clean.data.net.ServiceGenerator;

import com.shereen.weather_app_clean_architecture.data.Constants;
import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;
import com.shereen.weather_app_clean_architecture.data.net.ServiceGenerator;

import io.reactivex.Observable;

/**
 * Created by shereen on 11/6/18
 */

public class WeatherAPIDataStore
{

    public Observable<WeatherEntity> doServiceCall(){
            return ServiceGenerator.getWeatherService().getWeatherEntity();
    }

    public Observable<WeatherEntity> doCityServiceCall(String city){
        return ServiceGenerator.getWeatherService().getCityWeatherEntity(city, Constants.WEATHER_API_KEY);
    }


}
