package com.example.weatherapp.model

interface RepositoryImpl {

    fun getWeather(): CityInfo
    fun getWeatherFromLocalStorageRus(): List<CityInfo>
    fun getWeatherFromLocalStorageForeign(): List<CityInfo>

}