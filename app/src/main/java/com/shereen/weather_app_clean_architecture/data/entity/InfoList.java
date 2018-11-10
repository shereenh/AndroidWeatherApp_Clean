package com.shereen.weather_app_clean_architecture.data.entity;


import com.shereen.weather_app_clean_architecture.data.entity.infoList.Temp;
import com.shereen.weather_app_clean_architecture.data.entity.infoList.Weather;

import io.realm.RealmList;
import io.realm.RealmObject;

public class InfoList
   //     extends RealmObject
{

    private int dt;
    private Temp temp;
    private double pressure;
    private int humidity;
    //private RealmList<Weather> weather;
    private Weather[] weather;
    private double speed;
    private int deg;
    private int clouds;
    private double rain;

    public int getDt() {
        return dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }

    public double getRain() {
        return rain;
    }

   // public RealmList<Weather> getWeather() {return weather; }


    public Weather[] getWeather() {
        return weather;
    }
}
