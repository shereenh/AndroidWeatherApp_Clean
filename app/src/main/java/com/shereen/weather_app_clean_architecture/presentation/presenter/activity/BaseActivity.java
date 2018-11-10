package com.shereen.weather_app_clean_architecture.presentation.presenter.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.domain.entity.HolderEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by shereen on 11/8/18
 */

public abstract class BaseActivity extends AppCompatActivity {

    private List<String> myCities = new ArrayList<String>();

    private boolean connectedOnline = false;

    void BaseActivity(){

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initComponents();
        startFragments();

    }

    public List<String> getMyCities(){
        return myCities;
    }

    public void setMyCities(List<String> myCities){
        this.myCities = myCities;

    }

    public void addToMyCities(String city){
        myCities.add(city);
    }

    public boolean isConnectedOnline(){
        return connectedOnline;
    }

    public void setConnectedOnline(boolean connected){
        connectedOnline = connected;
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return false;
    }

    public abstract int getContentLayout();

    public abstract void initComponents();

    public abstract void startFragments();

}
