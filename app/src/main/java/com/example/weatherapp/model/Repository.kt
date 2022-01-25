package com.example.weatherapp.model

class Repository : RepositoryImpl {

    override fun getWeather(): CityInfo =
        CityInfo(City("Krasnodar", 3), 2)

    override fun getWeatherFromLocalStorageRus(): List<CityInfo> {
        return getRussianCities()
    }

    override fun getWeatherFromLocalStorageForeign(): List<CityInfo> {
        return getForeignCity()
    }
}