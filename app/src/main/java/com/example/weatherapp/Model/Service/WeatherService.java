package com.example.weatherapp.Model.Service;

import com.example.weatherapp.Model.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    //http://api.openweathermap.org/data/2.5/weather?q=Seville,es&appid=ebb8c9798744027a5ba1c60865ac7521

    @GET("weather")
    Call<City> receiveCity(@Query("q") String cityName, @Query("appid") String number);


}
