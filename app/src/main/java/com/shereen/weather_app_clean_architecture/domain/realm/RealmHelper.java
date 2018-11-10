package com.shereen.weather_app_clean_architecture.domain.realm;

import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.HolderEntity;

import java.sql.Timestamp;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
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

    public static void saveTime(){

        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                String now = (new Timestamp(System.currentTimeMillis())).toString();
                HolderEntity holderEntity = new HolderEntity();
                holderEntity.setId("1234");
                holderEntity.setLastRefreshed(now);
                realm.insertOrUpdate(holderEntity);
            }
        });

    }
}
