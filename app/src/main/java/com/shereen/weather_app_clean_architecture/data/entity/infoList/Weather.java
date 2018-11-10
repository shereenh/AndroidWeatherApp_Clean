package com.shereen.weather_app_clean_architecture.data.entity.infoList;
import io.realm.RealmList;
import io.realm.RealmObject;

public class Weather
       // extends RealmObject
{

    private int id;
    private String main;
    private String description;
    private String icon;

    public Weather() {
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
