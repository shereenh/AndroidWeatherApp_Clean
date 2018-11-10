package com.shereen.weather_app_clean_architecture.domain.business;

import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;
import com.shereen.weather_app_clean_architecture.presentation.model.WeatherPresEntity;

/**
 * Created by shereen on 11/8/18
 */

public class ImperialConverter {

    public static double kelvinToCelcius(double kelvin){
        return round(kelvin - 273.15,2);
    }

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public static double round2(double value){
        return(round(value,2));
    }




}
