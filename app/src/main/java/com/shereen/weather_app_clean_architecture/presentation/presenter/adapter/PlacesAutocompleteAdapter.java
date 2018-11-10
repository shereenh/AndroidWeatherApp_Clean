package com.shereen.weather_app_clean_architecture.presentation.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.shereen.weather_app_clean_architecture.R;

import java.util.ArrayList;

/**
 * Created by shereen on 11/8/18
 */

public class PlacesAutocompleteAdapter extends ArrayAdapter<String> implements Filterable {

    public ArrayList<String> resultList;

    Context mContext;
    int mResource;

    public PlaceAPI mPlaceAPI = new PlaceAPI();

    public PlacesAutocompleteAdapter(Context context, int resource) {
        super(context, resource);

        mContext = context;
        mResource = resource;
    }

    @Override
    public int getCount() {
        // Last item will be the footer
        return resultList.size();
    }

    @Override
    public String getItem(int position) {
        return resultList.get(position);
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };

        return filter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (position != (resultList.size() - 1))
            view = inflater.inflate(R.layout.autocomplete_list_item, null);
        else {
            view = inflater.inflate(R.layout.autocomplete_google_logo, null);
            view.setEnabled(false);
            view.setOnClickListener(null);
        }


        if (position != (resultList.size() - 1)) {
            TextView autocompleteTextView = (TextView) view.findViewById(R.id.autocompleteText);
            try {
                autocompleteTextView.setText(resultList.get(position));
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("And I don't know what to do");

        }

        return view;
    }


}
