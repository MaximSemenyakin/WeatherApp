package com.example.weatherapp.viewmodel

import com.example.weatherapp.model.CityInfo

sealed class AppCondition {
    data class Success(val weatherData: CityInfo): AppCondition()
    data class Error(val error: Throwable): AppCondition()
    object Loading: AppCondition()
}
