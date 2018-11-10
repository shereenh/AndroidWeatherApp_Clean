package com.shereen.weather_app_clean_architecture.domain.entity.mapper;

import com.shereen.weather_app_clean_architecture.data.entity.City;
import com.shereen.weather_app_clean_architecture.data.entity.InfoList;
import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;
import com.shereen.weather_app_clean_architecture.domain.business.ImperialConverter;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.DayEntity;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by shereen on 11/9/18
 */

public class DataToDomainMapper {

    public static CityEntity transformToCity(WeatherEntity weatherEntity){

        CityEntity cityEntity = new CityEntity();

        if(weatherEntity != null){

            cityEntity.setCityId( weatherEntity.getCity().getId() );
            cityEntity.setCity( weatherEntity.getCity().getName() );
            cityEntity.setCountry( weatherEntity.getCity().getCountry() );
            cityEntity.setDayTimeCount( weatherEntity.getCnt() );

            cityEntity.setDayEntityList( transformtoDayList(weatherEntity));

        }
        return cityEntity;
    }

    public static RealmList<DayEntity> transformtoDayList(WeatherEntity weatherEntity){

        RealmList<DayEntity> dayEntityList = new RealmList<>();

        if(weatherEntity != null){
            int i = 0;
            for(InfoList old : weatherEntity.getList()){

                DayEntity dayEntity = new DayEntity();

                dayEntity.setCityId(weatherEntity.getCity().getId());
                dayEntity.setIndex(i++);

                dayEntity.setTimeForecast( old.getDt() );

                dayEntity.setTempDay( Math.round(old.getTemp().getDay()) );
                dayEntity.setTempMin( Math.round(old.getTemp().getMin()) );
                dayEntity.setTempMax( Math.round(old.getTemp().getMax()) );
                dayEntity.setTempNight( Math.round(old.getTemp().getNight()) );
                dayEntity.setTempEve( Math.round(old.getTemp().getEve()) );
                dayEntity.setTempMorn( Math.round(old.getTemp().getMorn()) );

                dayEntity.setPressure( (int)Math.round(old.getPressure()) );
                dayEntity.setHumidity( old.getHumidity() );
                dayEntity.setWeatherMain( old.getWeather()[0].getMain() );
                dayEntity.setWeatherDescription( old.getWeather()[0].getDescription() );
                dayEntity.setWindSpeed( (int)Math.round(old.getSpeed()) );
                dayEntity.setWindDirection( old.getDeg() );
                dayEntity.setCloudiness( old.getClouds() );

                dayEntityList.add(dayEntity);

            }
        }
        return dayEntityList;
    }


}
