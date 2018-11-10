package com.shereen.weather_app_clean_architecture.data.entity.city;
import io.realm.RealmObject;

public class Coord
     //   extends RealmObject
{

    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
