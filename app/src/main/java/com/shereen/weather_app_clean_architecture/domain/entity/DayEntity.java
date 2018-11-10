package com.shereen.weather_app_clean_architecture.domain.entity;

import io.realm.RealmObject;

/**
 * Created by shereen on 11/9/18
 */

public class DayEntity extends RealmObject {

    private int cityId;
    private int index;
    private int timeForecast;

    private int tempDay;
    private int tempMin;
    private int tempMax;
    private int tempNight;
    private int tempEve;
    private int tempMorn;

    private int pressure;
    private int humidity;

    private String weatherMain;
    private String weatherDescription;


    private int windSpeed;
    private int windDirection;
    private int cloudiness;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTimeForecast() {
        return timeForecast;
    }

    public void setTimeForecast(int timeForecast) {
        this.timeForecast = timeForecast;
    }

    public int getTempDay() {
        return tempDay;
    }

    public void setTempDay(int tempDay) {
        this.tempDay = tempDay;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempNight() {
        return tempNight;
    }

    public void setTempNight(int tempNight) {
        this.tempNight = tempNight;
    }

    public int getTempEve() {
        return tempEve;
    }

    public void setTempEve(int tempEve) {
        this.tempEve = tempEve;
    }

    public int getTempMorn() {
        return tempMorn;
    }

    public void setTempMorn(int tempMorn) {
        this.tempMorn = tempMorn;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }
}
