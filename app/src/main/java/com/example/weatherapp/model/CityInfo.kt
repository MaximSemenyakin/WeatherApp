package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityInfo (val city: City = getDefaultCity(), val temperature: Int): Parcelable

fun getDefaultCity() = City("Краснодар",54.7387621,55.972055400000045)

fun getForeignCity() = listOf(
        CityInfo(City("Лондон",51.5085300, -0.1257400), -3),
        CityInfo(City("Рим",41.9027835,12.496365500000024), -3),
        CityInfo(City("Париж",48.8534100,2.3488000), -3),
        CityInfo(City("Токио",35.6895000,139.6917100), -3),
        CityInfo(City("Стамбул",41.0082376,28.97835889999999), -3),
        CityInfo(City("Вашингтон",38.9071923,-77.03687070000001), -3),
        CityInfo(City("Минск",53.90453979999999,27.561524400000053), -3),
        CityInfo(City("Киев",50.4501,30.523400000000038), -3),
        CityInfo(City("Берлин",52.52000659999999,13.404953999999975), -3),
        CityInfo(City("Пекин",39.90419989999999,116.40739630000007), -3)
        )

fun getRussianCities() = listOf(
        CityInfo(City("Москва",55.755826,37.617299900000035), -3),
        CityInfo(City("Санкт-Петербург",59.9342802,30.335098600000038), -3),
        CityInfo(City("Ростов",55.00835259999999,82.93573270000002), -3),
        CityInfo(City("Сочи",56.83892609999999,60.60570250000001), -3),
        CityInfo(City("Анапа",56.2965039,43.936059), -3),
        CityInfo(City("Ейск",55.8304307,49.06608060000008), -3),
        CityInfo(City("Кропоткин",55.1644419,61.4368432), -3),
        CityInfo(City("Мурманск",54.9884804,73.32423610000001), -3),
        CityInfo(City("Архангельск",47.2357137,39.701505), -3),
    )
