package com.example.weatherapp.View;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.example.weatherapp.Model.API.API;
import com.example.weatherapp.Model.City;
import com.example.weatherapp.R;
import com.example.weatherapp.Model.Service.WeatherService;

public class MainActivity extends AppCompatActivity {

    //to debug in logcat
    private static final String TAG = "MainActivity";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*here we put in motion the call to the server through the API*/

        //here we have the class that contains the url details to make the Query
        WeatherService service = API.getApi().create(WeatherService.class);

        //here we choose to what city to aim to following the structure set by the API creator.
        Call<City> call = service.receiveCity(" Seville,es" , API.API_KEY);
        //here we call
        call.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City cityInfo =  response.body();
                Log.d(TAG, "onResponse: country: " + cityInfo.getCountry());
                Log.d(TAG, "onResponse: city: " + cityInfo.getName());
                Log.d(TAG, "onResponse: id: " + cityInfo.getId());
                Log.d(TAG, "onResponse: code: " + cityInfo.getCode());
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.i(TAG, "onFailure: error: " + call.toString());
                Log.i(TAG, "onFailure: error 2: " + t.toString());
            }
        });

    }


}
