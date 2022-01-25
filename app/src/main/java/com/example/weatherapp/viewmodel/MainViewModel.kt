package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.RepositoryImpl
import java.lang.Thread.sleep

    class MainViewModel(private val liveDataToObserve: MutableLiveData<AppCondition> = MutableLiveData()) : ViewModel() {

    private val repository: RepositoryImpl = Repository()

    fun getLiveData() : LiveData<AppCondition> = liveDataToObserve

    fun getWeatherFromLocalRus() = getDataFromLocalStorage(isRussian = true)

    fun getWeatherFromLocalWorld() = getDataFromLocalStorage(isRussian = false)

    fun getWeatherFromRemote() = getDataFromLocalStorage(isRussian = true)

    private fun getDataFromLocalStorage(isRussian: Boolean) {
        liveDataToObserve.value = AppCondition.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppCondition.Success(if (isRussian)
                repository.getWeatherFromLocalStorageRus()
            else
                    repository.getWeatherFromLocalStorageForeign()))
        }.start()
    }

}