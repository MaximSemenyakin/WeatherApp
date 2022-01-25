package com.example.weatherapp.model

class Repository : RepositoryImpl {

    override fun getWeather(): CityInfo =
        CityInfo(City("Krasnodar", 3), 2)

    override fun getWeatherFromLocalStorageRus() =  getRussianCities()


    override fun getWeatherFromLocalStorageForeign() = getForeignCity()

}