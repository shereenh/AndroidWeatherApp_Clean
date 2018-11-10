package com.shereen.weather_app_clean_architecture.presentation;

import android.app.Application;

import com.shereen.weather_app_clean_architecture.data.Constants;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by shereen on 11/9/18
 */

public class WeatherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name(Constants.REALM_FILE_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
