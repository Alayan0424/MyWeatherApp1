package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.network.RetrofitInstance
import kotlinx.coroutines.launch


class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    fun fetchWeather(location: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getWeather(location, apiKey)
                _weatherData.postValue(response)
            } catch (e: Exception) {
                // Handle error (you can show an error message in the UI)
            }
        }
    }
}
