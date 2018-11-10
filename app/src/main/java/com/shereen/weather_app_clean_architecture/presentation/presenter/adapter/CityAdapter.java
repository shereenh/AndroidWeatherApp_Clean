package com.shereen.weather_app_clean_architecture.presentation.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.domain.entity.CityEntity;
import com.shereen.weather_app_clean_architecture.domain.entity.DayEntity;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by shereen on 11/9/18
 */

public class CityAdapter
        extends RealmRecyclerViewAdapter<CityEntity, CityAdapter.MyViewHolder> {

    OrderedRealmCollection<CityEntity> cityEntities;
    final String DEGREE_F  = "\u2109";
    final String DEGREE_C  = "\u00b0";


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView temp, mainW, press,humidity,speedW, country,city, minTemp, maxTemp;
        public ImageView icon;

        public MyViewHolder(View view) {
            super(view);

            temp = (TextView) view.findViewById(R.id.temp);
            mainW = (TextView) view.findViewById(R.id.mainW);
            press = (TextView) view.findViewById(R.id.pressure);
            humidity = (TextView) view.findViewById(R.id.humdidty);
            speedW = (TextView) view.findViewById(R.id.wind);
            country = (TextView) view.findViewById(R.id.Country);
            city = (TextView) view.findViewById(R.id.City);
            icon = (ImageView) view.findViewById(R.id.wicon);
            maxTemp = (TextView) view.findViewById(R.id.maxTemp);
            minTemp = (TextView) view.findViewById(R.id.minTemp);

        }
    }



    public CityAdapter(OrderedRealmCollection<CityEntity> cityEntities) {
        super(cityEntities,true,true);
        this.cityEntities = cityEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item, parent, false);

        System.out.println("445566: list used");

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        CityEntity cityEntity = cityEntities.get(position);
        DayEntity dayEntity = cityEntity.getDayEntityList().first();

        String wea = dayEntity.getWeatherMain();
        holder.mainW.setText( wea );
        holder.temp.setText( Double.toString(dayEntity.getTempDay()));
        holder.press.setText("Pr: "+Double.toString(dayEntity.getPressure() )+" hPa");
        holder.humidity.setText("Hm: "+Integer.toString(dayEntity.getHumidity())+"%");
        holder.speedW.setText("Wn: "+Double.toString(dayEntity.getWindSpeed())+" mps");
        holder.country.setText(cityEntity.getCountry());
        holder.city.setText( cityEntity.getCity()+", ");
        holder.minTemp.setText("Min: "+Double.toString(dayEntity.getTempMax()));
        holder.maxTemp.setText("Max: "+Double.toString(dayEntity.getTempMax()));
        if(wea.toLowerCase().contains("cloud")){
            holder.icon.setImageResource(R.drawable.cloudy);
        }else if(wea.toLowerCase().contains("overcast")){
            holder.icon.setImageResource(R.drawable.overcast);
        }else if(wea.toLowerCase().contains("clear")){
            holder.icon.setImageResource(R.drawable.clear);
        }else if(wea.toLowerCase().contains("sun")){
            holder.icon.setImageResource(R.drawable.sunny);
        }else if(wea.toLowerCase().contains("fog")){
            holder.icon.setImageResource(R.drawable.fog);
        }else if(wea.toLowerCase().contains("lightning")){
            holder.icon.setImageResource(R.drawable.lightning);
        }else if(wea.toLowerCase().contains("thunder")){
            holder.icon.setImageResource(R.drawable.thunder);
        }else if(wea.toLowerCase().contains("rainbow")){
            holder.icon.setImageResource(R.drawable.rainbow);
        }else if(wea.toLowerCase().contains("rain")){
            holder.icon.setImageResource(R.drawable.rain);
        }else if(wea.toLowerCase().contains("snow")){
            holder.icon.setImageResource(R.drawable.snowy);
        }else if(wea.toLowerCase().contains("storm")){
            holder.icon.setImageResource(R.drawable.storm);
        }else if(wea.toLowerCase().contains("tornado")){
            holder.icon.setImageResource(R.drawable.tornado);
        }else if(wea.toLowerCase().contains("haze")){
            holder.icon.setImageResource(R.drawable.fog);
        }else if(wea.toLowerCase().contains("drizzle")){
            holder.icon.setImageResource(R.drawable.drizzle);
        }else if(wea.toLowerCase().contains("mist")){
            holder.icon.setImageResource(R.drawable.fog);
        }else{
            holder.icon.setImageResource(R.drawable.sunny);
        }

    }

    @Override
    public int getItemCount() {
        return cityEntities.size();
    }


}
