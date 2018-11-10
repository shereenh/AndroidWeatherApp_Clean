package com.shereen.weather_app_clean_architecture.data.repository;

//import com.shereen.weather_clean.data.entity.WeatherEntity;
//import com.shereen.weather_clean.data.entity.mapper.WeatherMapper;
//import com.shereen.weather_clean.data.repository.datasource.WeatherDataStoreFactory;
//import com.shereen.weather_clean.domain.model.WeatherDomModel;
//import com.shereen.weather_clean.domain.repository.WeatherModelRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by shereen on 11/6/18
 */

public class WeatherDataRepository
        //implements WeatherModelRepository
{

//    private final WeatherDataStoreFactory weatherDataStoreFactory;
//    private final WeatherMapper weatherMapper;
//
//    public WeatherDataRepository(WeatherDataStoreFactory weatherDataStoreFactory,WeatherMapper weatherMapper){
//        this.weatherDataStoreFactory = weatherDataStoreFactory;
//        this.weatherMapper = weatherMapper;
//    }
//    @Override
//    public Observable<WeatherDomModel> weatherDomModel() {
//        return weatherDataStoreFactory.create().weatherEntity().map(new Function<WeatherEntity, WeatherDomModel>() {
//            @Override
//            public WeatherDomModel apply(WeatherEntity weatherEntity) throws Exception {
//                return weatherMapper.transform(weatherEntity);
//            }
//        });
//    }


}
