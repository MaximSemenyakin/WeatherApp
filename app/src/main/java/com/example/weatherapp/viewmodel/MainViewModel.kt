package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.model.Repository
import com.example.weatherapp.model.RepositoryImpl
import java.lang.Exception
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserve: MutableLiveData<AppCondition> = MutableLiveData()) : ViewModel() {

    private val repository: RepositoryImpl = Repository()

    fun getLiveData() : LiveData<AppCondition> = liveDataToObserve

    fun getWeather() {
        liveDataToObserve.postValue(AppCondition.Loading)
        Thread{
            sleep(3500)
            when((0..1).random()) {
                1 -> {
                    liveDataToObserve.postValue(AppCondition.Success(repository.getWeather()))
                }
                0 -> {
                    liveDataToObserve.postValue(AppCondition.Error(Throwable("Try again")))
                }
            }

        }.start()
    }

}