package com.shereen.weather_app_clean_architecture.domain.entity;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by shereen on 11/9/18
 */

public class CityEntity extends RealmObject {

    @PrimaryKey
    public int cityId;
    private String city;
    private String country;
    private int dayTimeCount;
    private String tester;

    RealmList<DayEntity> dayEntityList;

//    public CityEntity(){}
//
//    public CityEntity(int cityId, String city, String country, int dayTimeCount) {
//        this.cityId = cityId;
//        this.city = city;
//        this.country = country;
//        this.dayTimeCount = dayTimeCount;
//    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDayTimeCount() {
        return dayTimeCount;
    }

    public void setDayTimeCount(int dayTimeCount) {
        this.dayTimeCount = dayTimeCount;
    }

    public RealmList<DayEntity> getDayEntityList() {
        return dayEntityList;
    }

    public void setDayEntityList(RealmList<DayEntity> dayEntityList) {
        this.dayEntityList = dayEntityList;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }
}
