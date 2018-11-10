package com.shereen.weather_app_clean_architecture.presentation.presenter.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shereen.weather_app_clean_architecture.R;
import com.shereen.weather_app_clean_architecture.presentation.presenter.adapter.PlacesAutocompleteAdapter;

import java.util.ArrayList;


public class AutocompleteFragment extends BaseFragment {

    HandlerThread mHandlerThread;
    Handler mThreadHandler;
    AutoCompleteTextView autocompleteView;
    private PlacesAutocompleteAdapter mAdapter;
    View rootView;
    AutoCompleteTextView editCity;
    private final String INTERNET_MESSAGE = "Please check internet connectivity";
    private final String EMPTY_MESSAGE = "Please enter a city";
    private final String OTHER_MESSAGE = "Something went wrong. Please try again later.";

    ImageButton getWeather;

    LinearLayout topLayout;

    LayoutInflater rootInflater;
    private OnAutoFragmentInteractionListener mListener;

    //    Switch locationSwitch;
    SwitchCompat locationSwitch;

    public void initialize(){

        boolean connected = false;

        if(mListener!=null){
            connected = mListener.getConnected();
        }


        if (mThreadHandler == null) {
            // Initialize and start the HandlerThread
            // which is basically a Thread with a Looper
            // attached (hence a MessageQueue)
            mHandlerThread = new HandlerThread("AutocompleteFragment", android.os.Process.THREAD_PRIORITY_BACKGROUND);
            mHandlerThread.start();

            // Initialize the Handler
            mThreadHandler = new Handler(mHandlerThread.getLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 1) {
                        ArrayList<String> results = mAdapter.resultList;

                        if (results != null && results.size() > 0) {
                            System.out.println("1Thread: "+Thread.currentThread().getName());
                            try{
                                mAdapter.notifyDataSetChanged();}catch(Exception e){
                                System.out.println("Attention!!!");
                                e.printStackTrace();
                            }
                        }
                        else {
                            mAdapter.notifyDataSetInvalidated();
                        }
                    }
                }
            };
        }
        else{
            //Toast.makeText(getActivity(), INTERNET_MESSAGE, Toast.LENGTH_SHORT).show();

        }

    }

    public View customOnCreate(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState){
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_autocomplete, container, false);
        rootInflater = inflater;

        topLayout = rootView.findViewById(R.id.current);
        //Autocomplete
        autocompleteView = (AutoCompleteTextView)rootView.findViewById(R.id.city_name);

        mAdapter = new PlacesAutocompleteAdapter(getActivity(), R.layout.autocomplete_list_item);
        autocompleteView.setAdapter(mAdapter);

        //  autocompleteView.setAdapter(new PlacesAutoCompleteAdapter(this, R.layout.autocomplete_list_item));

        autocompleteView.addTextChangedListener(new TextChanged());

        autocompleteView.setOnClickListener(new ClearEditText());

        editCity = rootView.findViewById(R.id.city_name);

        getWeather = rootView.findViewById(R.id.getWeather);
        getWeather.setOnClickListener(new GetWeatherClick());

        return rootView;
    }

    class GetWeatherClick implements View.OnClickListener{

        @Override
        public void onClick(android.view.View v) {

            boolean connected = false;


            if(editCity.getText().toString().equals("")){

                Toast.makeText(getActivity(), EMPTY_MESSAGE, Toast.LENGTH_SHORT).show();

            }else if(mListener!=null){

                connected = mListener.getConnected();
                if(!connected){
                    Toast.makeText(getActivity(), INTERNET_MESSAGE, Toast.LENGTH_SHORT).show();
                }else{
                    mListener.fromAutoFrag(editCity.getText().toString());
                }

            }else{
                Toast.makeText(getActivity(), OTHER_MESSAGE, Toast.LENGTH_SHORT).show();
            }

            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

        }

    }

    class ClearEditText implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            autocompleteView.setText("");
            System.out.println("CLEARED!");
        }

    }

    class TextChanged implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            System.out.println("Just so you know: "+s);
            final String value = s.toString();

            if(mThreadHandler != null){
                // Remove all callbacks and messages
                mThreadHandler.removeCallbacksAndMessages(null);

                // Now add a new one
                mThreadHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // Background thread
                        mAdapter.resultList = mAdapter.mPlaceAPI.autocomplete(value);

                        // Footer
                        if (mAdapter.resultList.size() > 0)
                            mAdapter.resultList.add("footer");

                        // Post to Main Thread
                        mThreadHandler.sendEmptyMessage(1);
                    }
                }, 500);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            // doAfterTextChanged();
        }
    }


    @Override
    public void doAttach(Context context){
        if (context instanceof OnAutoFragmentInteractionListener) {
            mListener = (OnAutoFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void doDetach(){
        mListener = null;
    }

    @Override
    public void doDestroyView(){

        if (mThreadHandler != null) {
            mThreadHandler.removeCallbacksAndMessages(null);
            mHandlerThread.quit();
        }
    }

    public interface OnAutoFragmentInteractionListener {

        void fromAutoFrag(String city);
        boolean getConnected();

    }
}
