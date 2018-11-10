package com.shereen.weather_app_clean_architecture.presentation.presenter.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.data.entity.City;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.DayEntity;
import com.shereen.weather_app_clean_architecture.presentation.presenter.adapter.CityAdapter;
import com.shereen.weather_app_clean_architecture.presentation.presenter.adapter.DayAdapter;
import com.shereen.weather_app_clean_architecture.presentation.presenter.fragment.helper.RecyclerItemClickListener;

import io.realm.Realm;
import io.realm.RealmResults;

public class DayFragment extends BaseFragment {

    private DayFragment.OnFragmentInteractionListener mListener;
    View rootView;

    private RecyclerView recyclerView;
    private DayAdapter dayAdapter;

    //OrderedRealmCollection<CityEntity> cityEntities;
    RealmResults<DayEntity> dayEntities;

    ImageButton changeFragButton;

    Realm realm;

    public DayFragment() {
        // Required empty public constructor
    }

    public void initialize(){

    }

    @Override
    public View customOnCreate(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_day, container, false);
        if(mListener != null){
            mListener.sendTheId();
        }

        changeFragButton = rootView.findViewById(R.id.changeFrag);
        changeFragButton.setOnClickListener(new ChangeFragment());

        return rootView;
    }

    public void displayThisInformation(int cityId){

        realm = Realm.getDefaultInstance();
        dayEntities = realm.where(DayEntity.class).equalTo("cityId",new Integer(cityId)).findAll();

        for(DayEntity day: dayEntities){
            System.out.println("--->d "+day.getCityId()+" "+day.getTempDay());
        }


        dayAdapter = new DayAdapter(dayEntities);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager
                (getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(dayAdapter);

    }

    class ChangeFragment implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if(mListener !=null){
                mListener.changeToCityFragment();
            }
        }

    }


    @Override
    public void doAttach(Context context) {
        realm = Realm.getDefaultInstance();
        if (context instanceof CityFragment.OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void doDetach() {
        mListener = null;
        realm.close();
    }

    @Override
    public void doDestroyView() {
        mListener = null;
        realm.close();
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //void onFragmentInteraction(Uri uri);
        void sendTheId();
        void changeToCityFragment();
    }

}
