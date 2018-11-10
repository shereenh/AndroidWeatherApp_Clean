package com.shereen.weather_app_clean_architecture.data.cache;



import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.Observable;
import io.realm.Realm;

/**
 * Created by shereen on 11/6/18
 */

public class WeatherCacheImpl implements WeatherCache {

    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

//    @Override
//    public boolean isExpired(){
//        Realm realm = Realm.getDefaultInstance();
//        if (realm.where(WeatherEntity.class).count() != 0) {
//            Date currentTime = new Date(System.currentTimeMillis());
//            SimpleDateFormat ISO8601DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);
//            Date lastUpdated = null;
//            try {
//                lastUpdated = ISO8601DATEFORMAT.parse(realm.where(WeatherEntity.class).findFirst().getLastUpdated());
//                boolean isExpired = currentTime.getTime() - lastUpdated.getTime() > EXPIRATION_TIME;
//                if(isExpired){
//                    realm.beginTransaction();
//                    realm.delete(WeatherEntity.class);
//                    realm.commitTransaction();
//                }
//                return isExpired;
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } finally {
//                realm.close();
//            }
//
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isCached(){
//
//        WeatherEntity weatherEntity = getWeatherEntity();
//        return weatherEntity != null;
//    }
//
//    @Override
//    public Observable<WeatherEntity> get() {
//        WeatherEntity weatherEntity = getWeatherEntity();
//        return Observable.just(weatherEntity);
//    }
//
//    @Override
//    public void put(WeatherEntity weatherEntity) {
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        realm.copyToRealmOrUpdate(weatherEntity);
//        realm.commitTransaction();
//        realm.close();
//    }
//
//
//
//    private WeatherEntity getWeatherEntity() {
//        Realm realm = Realm.getDefaultInstance();
//        WeatherEntity weatherEntity = realm.copyFromRealm(
//                realm.where(WeatherEntity.class).findFirst());
//        realm.close();
//        return weatherEntity;
//    }


}
