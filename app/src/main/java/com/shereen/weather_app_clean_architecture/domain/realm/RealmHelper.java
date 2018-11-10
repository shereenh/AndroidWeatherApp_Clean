package com.shereen.weather_app_clean_architecture.domain.realm;

import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by shereen on 11/9/18
 */

public class RealmHelper {

    public static void saveToRealm(CityEntity cityEntity){

        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                CityEntity savedCity = new CityEntity();//realm.createObject(CityEntity.class, cityEntity.getCityId());
                savedCity.setCityId( cityEntity.getCityId());
                savedCity.setCity( cityEntity.getCity());
                savedCity.setCountry( cityEntity.getCountry() );
                savedCity.setDayTimeCount( cityEntity.getDayTimeCount() );
                savedCity.setTester( UUID.randomUUID().toString() );
                savedCity.setDayEntityList( cityEntity.getDayEntityList());
                realm.insertOrUpdate(savedCity);
            }
        });

    }

    public static void checkAgain(){

        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults<CityEntity> cityEntities = realm.where(CityEntity.class).findAll();
                for(CityEntity city: cityEntities){
                    String val = city.getDayEntityList().first().getWeatherDescription();
                    System.out.println("-->>m "+city.getCityId()+" "+city.getCity()+" "+val);

                }
            }
        });

    }
}
