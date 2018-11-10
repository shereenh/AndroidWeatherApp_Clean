package com.shereen.weather_app_clean_architecture.data.entity;

import java.util.Arrays;

/**
 * Created by shereen on 11/8/18
 */

public class WeatherEntity {

    private City city;
    private String cod;
    private String message;
    private int cnt;
    private InfoList[] list;

    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public InfoList[] getList() {
        return list;
    }

    @Override
    public String toString() {
        return "----> TopLevel{" +
                "city=" + city +
                ", cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + Arrays.toString(list) +
                '}';
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
