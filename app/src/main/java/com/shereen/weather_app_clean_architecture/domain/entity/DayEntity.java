package com.shereen.weather_app_clean_architecture.domain.entity;

import io.realm.RealmObject;

/**
 * Created by shereen on 11/9/18
 */

public class DayEntity extends RealmObject {

    private int cityId;
    private int index;
    private int timeForecast;

    private double tempDay;
    private double tempMin;
    private double tempMax;
    private double tempNight;
    private double tempEve;
    private double tempMorn;

    private double pressure;
    private int humidity;

    private String weatherMain;
    private String weatherDescription;


    private double windSpeed;
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

    public double getTempDay() {
        return tempDay;
    }

    public void setTempDay(double tempDay) {
        this.tempDay = tempDay;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempNight() {
        return tempNight;
    }

    public void setTempNight(double tempNight) {
        this.tempNight = tempNight;
    }

    public double getTempEve() {
        return tempEve;
    }

    public void setTempEve(double tempEve) {
        this.tempEve = tempEve;
    }

    public double getTempMorn() {
        return tempMorn;
    }

    public void setTempMorn(double tempMorn) {
        this.tempMorn = tempMorn;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
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

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
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
