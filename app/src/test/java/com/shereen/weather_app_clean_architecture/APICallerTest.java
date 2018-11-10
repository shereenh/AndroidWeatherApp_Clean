package com.shereen.weather_app_clean_architecture;

import com.shereen.weather_app_clean_architecture.data.entity.City;
import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.mapper.DataToDomainMapper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shereen on 11/9/18
 */

public class APICallerTest {

    final String cityName = "sampleCity";
    final int cityId = 1234;
    final String country = "sampleCountry";


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void dataToDomainMapping() {

        WeatherEntity weatherEntity = new WeatherEntity();
        City city = new City();

        city.setName(cityName);
        city.setId(cityId);
        city.setCountry(country);

        weatherEntity.setCity(city);

        CityEntity cityEntity = DataToDomainMapper.transformToCity(weatherEntity);


        assertEquals(cityName, cityEntity.getCity());
        assertEquals(cityId, cityEntity.getCityId());
        assertEquals(country, cityEntity.getCountry());
    }
}
