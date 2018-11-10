package com.shereen.weather_app_clean_architecture.presentation.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.domain.APICaller;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.presentation.presenter.fragment.AutocompleteFragment;
import com.shereen.weather_app_clean_architecture.presentation.presenter.fragment.CityFragment;
import com.shereen.weather_app_clean_architecture.presentation.presenter.fragment.DayFragment;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;


public class MainActivity extends BaseActivity implements
        AutocompleteFragment.OnAutoFragmentInteractionListener,
        CityFragment.OnFragmentInteractionListener,
        DayFragment.OnFragmentInteractionListener{

    AutocompleteFragment autocompleteFragment;
    CityFragment cityFragment;
    DayFragment dayFragment;
    APICaller apiCaller;
    int cityId;

    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm realm;


    public void makeAPICall(String city){
        System.out.println("Clicked!");
        //makeCall
        apiCaller.cityDomainCaller(city);
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponents() {

        checkNetwork();
        setUpData();

        apiCaller = new APICaller();
//        townshipAdapter = new TownshipAdapter();
//        recycler.setLayoutManager(new GridLayoutManager(this,2));
//        recycler.setAdapter(townshipAdapter);
//        townshipModelMapper = new TownshipModelMapper();
//        townshipMapper = new TownshipMapper();
//        townshipCache = new TownshipCacheImpl();
//        townshipDataStoreFactory = new TownshipDataStoreFactory(townshipCache);
//        townshipDataRepository = new TownshipDataRepository(townshipDataStoreFactory,townshipMapper);
//        getTownshipList = new GetTownshipList(townshipDataRepository);
//        townshipListPresenter = new TownshipListPresenter(getTownshipList,townshipModelMapper);
//        townshipListPresenter.setTownshipListView(this);
//        townshipListPresenter.initialize();
    }

    private void checkNetwork(){

        if(isOnline() && isNetworkAvailable()){
            print("Found internet");
            setConnectedOnline(true);
        }else{
            print("Internet not found");
            setConnectedOnline(false);
            Toast.makeText(this, "Please connect to the internet and relaunch the app. ", Toast.LENGTH_LONG).show();
        }

    }

    private void setUpData(){
        List<String> mySavedCities = new ArrayList<String>();

        realm = Realm.getDefaultInstance();

        print("All saved:");

        RealmResults<CityEntity> cityEntities = realm.where(CityEntity.class).findAll();
        for(CityEntity city: cityEntities){
            String val = city.getDayEntityList().first().getWeatherDescription();
            print("--> "+city.getCityId()+" "+city.getCity()+" "+val);
            mySavedCities.add( city.getCity() );
        }

        if(mySavedCities.size()>0){
            setMyCities(mySavedCities);
        }
    }

    @Override
    public void startFragments(){
        autocompleteFragment = new AutocompleteFragment();
        cityFragment = new CityFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.topFrame, autocompleteFragment,"autocomplete")
                .commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.bottomFrame, cityFragment,"weatherList")
                .commit();
    }

    @Override
    public void fromAutoFrag(String city){
        System.out.println("Recieved: "+city);
        makeAPICall(city);
    }

    @Override
    public boolean getConnected(){
        return isConnectedOnline();
    }

    public void print(String mes){
        System.out.println(mes);
    }

    @Override
    public void openMoreInformation(int cityId){

        System.out.println("going to call");
        this.cityId = cityId;
        dayFragment = new DayFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.bottomFrame, dayFragment,"dayFragment")
                .commit();
    }

    @Override
    public void sendTheId(){

        System.out.println("recieved response");
        if(dayFragment!=null){
            dayFragment.displayThisInformation(cityId);
        }
    }

    @Override
    public void changeToCityFragment(){

        if(cityFragment == null){
            cityFragment = new CityFragment();
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.bottomFrame, cityFragment,"cityFragment")
                .commit();
    }
}
