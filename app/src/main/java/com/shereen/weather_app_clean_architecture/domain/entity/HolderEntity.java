package com.shereen.weather_app_clean_architecture.domain.entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by shereen on 11/10/18
 */

public class HolderEntity extends RealmObject {

    @PrimaryKey
    String id;

    String lastRefreshed;

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
