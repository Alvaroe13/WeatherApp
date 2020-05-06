package com.example.weatherapp.Model;

public class City {

    private int id;
    private String name, country;
    private int code;

    public City(){

    }

    public City(int id, String name, int code, String country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

