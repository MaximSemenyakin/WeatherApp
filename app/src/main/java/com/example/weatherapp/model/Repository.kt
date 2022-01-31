package com.example.weatherapp.model

class Repository : RepositoryImpl {

    override fun getWeather(): CityInfo =
        CityInfo(City("Krasnodar",54.7387621,55.972055400000045), 2)

    override fun getWeatherFromLocalStorageRus() =  getRussianCities()


    override fun getWeatherFromLocalStorageForeign() = getForeignCity()

}