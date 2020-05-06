package com.example.weatherapp.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    /*this class is not used since the method created at the very end of the class is to deserialize only in one
     inner object retrieved in the JSON, by creating a custom deserializer "TheDeserializer.java" in this case
     we get access to every inner object within the JSON fetched from the server.
     Watch UDEMY course in case you need to refresh this topic at some point. */

    @SerializedName("temp")
    private String temperature;
    private String pressure;
    private String humidity;
    @SerializedName("temp_min")
    private String temperatureMin;
    @SerializedName("temp_max")
    private String temperatureMax;

    public Temperature(){
    }

    public Temperature(String temperature, String pressure, String humidity, String temperatureMin, String temperatureMax) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    //custom deserializer to re
    public static Temperature getJSON(String response){
        Gson gson = new GsonBuilder().create();
        Temperature temperature = gson.fromJson(response, Temperature.class);
        return  temperature;
    }


}
