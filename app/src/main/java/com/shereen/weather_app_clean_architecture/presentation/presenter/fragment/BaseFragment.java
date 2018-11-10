package com.shereen.weather_app_clean_architecture.presentation.presenter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shereen.weather_app_clean_architecture.presentation.presenter.adapter.PlacesAutocompleteAdapter;

/**
 * Created by shereen on 11/8/18
 */

public abstract class BaseFragment extends Fragment {

    public BaseFragment(){

        initialize();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("Fragment is initialized");
        return customOnCreate(inflater,container,savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        doAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        doDetach();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        doDestroyView();
    }

    public abstract void initialize();

    public abstract View customOnCreate(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState);

    public abstract void doAttach(Context context);

    public abstract void doDetach();

    public abstract void doDestroyView();


}
