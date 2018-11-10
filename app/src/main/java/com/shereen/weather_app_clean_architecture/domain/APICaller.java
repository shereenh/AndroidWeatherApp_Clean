package com.shereen.weather_app_clean_architecture.domain;

import android.util.Log;


import com.shereen.weather_app_clean_architecture.data.entity.WeatherEntity;
import com.shereen.weather_app_clean_architecture.data.repository.datasource.WeatherAPIDataStore;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.mapper.DataToDomainMapper;
import com.shereen.weather_app_clean_architecture.domain.realm.RealmHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;

/**
 * Created by shereen on 11/8/18
 */
//Make API call and save the data to the database (realm)
public class APICaller {

    private static final String TAG = APICaller.class.getSimpleName();
    private Realm realm;
    String returnResult ="";


    public APICaller(){
        realm = Realm.getDefaultInstance();
    }

    WeatherAPIDataStore dataStore;

    public void domainCaller(){

        dataStore = new WeatherAPIDataStore();

        Disposable disposable = dataStore
                .doServiceCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(

                        new Consumer<WeatherEntity>() {
                            @Override
                            public void accept(WeatherEntity gitHubRepos) throws Exception {
                                //System.out.println("Thread stuff 1 toplelevl "+ Thread.currentThread().getName());
                                Log.i(TAG, "RxJava2: Response from server for toplevel ...");
                                //recyclerAdapter.setGitHubRepos(gitHubRepos);
                                System.out.println("result from call: "+gitHubRepos.getMessage()+" "+gitHubRepos.getCity().getName());

                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable t) throws Exception {
                                Log.i(TAG, "RxJava2, HTTP Error: " + t.getMessage());
                            }
                        }

                );

    }

    public void cityDomainCaller(String city){

        dataStore = new WeatherAPIDataStore();

        Disposable disposable = dataStore
                .doCityServiceCall(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(

                        new Consumer<WeatherEntity>() {
                            @Override
                            public void accept(WeatherEntity weatherEntity) throws Exception {
                                Log.i(TAG, "RxJava2: Response from server for toplevel ...");
                                System.out.println("result from call: "+weatherEntity.getMessage()+" "+weatherEntity.getCity().getName());
                                checkForFaults(weatherEntity);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable t) throws Exception {
                                Log.i(TAG, "RxJava2, HTTP Error: " + t.getMessage());
                            }
                        }

                );
    }

    public void checkForFaults(WeatherEntity weatherEntity){


        if(weatherEntity.getCod().equals("202")){
            saveToDatabase(weatherEntity);
            returnResult = "OK";
        }else{
            returnResult = weatherEntity.getMessage();
        }

    }

    public void saveToDatabase(WeatherEntity weatherEntity){

        CityEntity cityEntity = DataToDomainMapper.transformToCity(weatherEntity);
        if(cityEntity != null){

            try{

                RealmHelper.saveToRealm(cityEntity);

            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }


}
