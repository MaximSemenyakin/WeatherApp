package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityInfo (val city: City = getDefaultCity(), val temperature: Int): Parcelable

fun getDefaultCity() = City("Краснодар", -2)

fun getForeignCity(): List<CityInfo> {
    return listOf(
        CityInfo(City("Лондон", -3), -3),
        CityInfo(City("Рим", -3), -3),
        CityInfo(City("Париж", -3), -3),
        CityInfo(City("Нью-йорк", -3), -3),
        CityInfo(City("Вашингтон", -3), -3),
        CityInfo(City("Дубай", -3), -3),
        CityInfo(City("Минск", -3), -3),
        CityInfo(City("Киев", -3), -3),
        CityInfo(City("Берлин", -3), -3),
        CityInfo(City("Мадрид", -3), -3)
        )
}

fun getRussianCities(): List<CityInfo> {
    return listOf(
        CityInfo(City("Москва", -3), -3),
        CityInfo(City("Санкт-Петербург", -3), -3),
        CityInfo(City("Ростов", -3), -3),
        CityInfo(City("Сочи", -3), -3),
        CityInfo(City("Анапа", -3), -3),
        CityInfo(City("Ейск", -3), -3),
        CityInfo(City("Кропоткин", -3), -3),
        CityInfo(City("Мурманск", -3), -3),
        CityInfo(City("Архангельск", -3), -3),
    )
}