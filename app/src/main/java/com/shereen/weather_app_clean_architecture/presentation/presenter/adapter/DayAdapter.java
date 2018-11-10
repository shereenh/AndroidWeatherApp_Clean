package com.shereen.weather_app_clean_architecture.presentation.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.domain.entity.DayEntity;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by shereen on 11/9/18
 */

public class DayAdapter extends RealmRecyclerViewAdapter<DayEntity, DayAdapter.MyViewHolder> {

    OrderedRealmCollection<DayEntity> dayEntities;
    final String DEGREE_F  = "\u2109";
    final String DEGREE_C  = "\u00b0";


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView day, min, max,night,eve, morn;

        public MyViewHolder(View view) {
            super(view);

            day = (TextView) view.findViewById(R.id.day);
            min = (TextView) view.findViewById(R.id.min);
            max = (TextView) view.findViewById(R.id.max);
            night = (TextView) view.findViewById(R.id.night);
            eve = (TextView) view.findViewById(R.id.eve);
            morn = (TextView) view.findViewById(R.id.morn);

        }
    }



    public DayAdapter(OrderedRealmCollection<DayEntity> dayEntities) {
        super(dayEntities,true,true);
        this.dayEntities = dayEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_item, parent, false);

        System.out.println("445566: list used");

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        DayEntity dayEntity = dayEntities.get(position);
        System.out.println("ValueL: "+dayEntity.getTempDay());

        holder.day.setText( Double.toString(dayEntity.getTempDay()) );
        holder.min.setText(Double.toString(dayEntity.getTempMin()));
        holder.max.setText(Double.toString(dayEntity.getTempMax()));
        holder.night.setText(Double.toString(dayEntity.getTempNight()));
        holder.eve.setText(Double.toString(dayEntity.getTempEve()));
        holder.morn.setText( Double.toString(dayEntity.getTempMorn()));

    }

    @Override
    public int getItemCount() {
        return dayEntities.size();
    }


}
