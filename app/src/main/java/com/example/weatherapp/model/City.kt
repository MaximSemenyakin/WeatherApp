package com.example.weatherapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class City (val name: String, val temperature: Int): Parcelable