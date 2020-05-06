package com.example.weatherapp.Model.Deserializer;

import android.util.Log;

import com.example.weatherapp.Model.City;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class TheDeserializer implements JsonDeserializer<City> {

    private String cityName, country;
    private int id1, id2, code;
    private double temperature;


    //here we deserialize all the info coming from the server in a JSON format.
    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        //this we don't use, just to practice fetching info from other objects within the JSON info
        temperature = json.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsDouble();
        id2 = json.getAsJsonObject().get("sys").getAsJsonObject().get("id").getAsInt(); //id from within the inner object.

        //we fetch info from the server
        cityName = json.getAsJsonObject().get("name").getAsString(); // city name that is out of the inner object
        id1 = json.getAsJsonObject().get("id").getAsInt(); //id from outside the inner object.
        country = json.getAsJsonObject().get("sys").getAsJsonObject().get("country").getAsString();
        code = json.getAsJsonObject().get("cod").getAsInt();

        //here we set info retrieved above using the model class
        City city1 = new City(id1, cityName, code, country);

        return city1;
    }

}
