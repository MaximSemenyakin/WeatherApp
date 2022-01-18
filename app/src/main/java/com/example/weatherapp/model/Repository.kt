package com.example.weatherapp.model

class Repository : RepositoryImpl {

    override fun getWeather(): CityInfo =
        CityInfo("Krasnodar", 2)

}