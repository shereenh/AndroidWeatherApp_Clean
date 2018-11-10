package com.shereen.weather_app_clean_architecture.data.entity;

import com.shereen.weather_app_clean_architecture.data.entity.city.Coord;

import io.realm.RealmObject;

public class City
//extends RealmObject
 {

    private int id;
    private String name;
    private Coord coord;
    private String country;
    private int population;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

     public void setId(int id) {
         this.id = id;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setCountry(String country) {
         this.country = country;
     }

 }
