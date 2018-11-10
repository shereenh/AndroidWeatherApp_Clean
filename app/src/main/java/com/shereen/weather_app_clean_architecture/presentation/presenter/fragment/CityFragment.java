package com.shereen.weather_app_clean_architecture.presentation.presenter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.presentation.presenter.adapter.CityAdapter;
import com.shereen.weather_app_clean_architecture.presentation.presenter.fragment.helper.RecyclerItemClickListener;

import io.realm.Realm;
import io.realm.RealmResults;


public class CityFragment extends BaseFragment {

    private OnFragmentInteractionListener mListener;
    View rootView;

    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;

    //OrderedRealmCollection<CityEntity> cityEntities;
    RealmResults<CityEntity> cityEntities;

    Realm realm;

    public CityFragment() {
        // Required empty public constructor
    }

    public void initialize(){

    }

    @Override
    public View customOnCreate(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        realm = Realm.getDefaultInstance();
        rootView = inflater.inflate(R.layout.fragment_city, container, false);

        cityEntities = realm.where(CityEntity.class).findAll();

        for(CityEntity city: cityEntities){
            System.out.println("---> "+city.getCityId()+" "+city.getCity());
        }


        cityAdapter = new CityAdapter(cityEntities);

        recyclerView = rootView.findViewById(R.id.recyclerView_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager
                (getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(cityAdapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView ,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View view, int position) {
                                Toast.makeText(getActivity(), "on Click "+cityEntities.get(position).getCity(), Toast.LENGTH_SHORT).show();
                                if(mListener != null){
                                    mListener.openMoreInformation(cityEntities.get(position).getCityId());
                                }
                            }

                            @Override public void onLongItemClick(View view, int position) {
                                Toast.makeText(getActivity(), "on Long Click "+cityEntities.get(position).getCity(), Toast.LENGTH_SHORT).show();
                                if(mListener != null){
                                    mListener.openMoreInformation(cityEntities.get(position).getCityId());
                                }
                            }
                        })
        );
        return rootView;
    }




    @Override
    public void doAttach(Context context) {
        realm = Realm.getDefaultInstance();
        if (context instanceof OnFragmentInteractionListener) {
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
        void openMoreInformation(int cityId);
    }
}
