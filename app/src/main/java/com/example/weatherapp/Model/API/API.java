package com.example.weatherapp.Model.API;

import com.example.weatherapp.Model.City;
import com.example.weatherapp.Model.Deserializer.TheDeserializer;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    //these are the url's to use in the app
    //http://api.openweathermap.org/data/2.5/weather?q=Seville,es&appid=ebb8c9798744027a5ba1c60865ac7521
    //api key = ebb8c9798744027a5ba1c60865ac7521

    public static final String BASE_URL  = "http://api.openweathermap.org/data/2.5/";
    public static final String API_KEY  = "ebb8c9798744027a5ba1c60865ac7521";
    private static Retrofit retrofit = null;

    //singleton instance
    public static Retrofit getApi(){
        if (retrofit == null){

            //here we instantiate the deserializer created by us "TheDeserializer.java"
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(City.class, new TheDeserializer());

             retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                     //we pass deserializer to retrofit for them to work in conjunction
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
       return retrofit;
    }

}
