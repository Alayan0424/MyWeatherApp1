package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.WeatherResponse
import com.example.myweatherapp.ForecastResponse // ✅ Import your forecast model
import com.example.weatherapp.network.RetrofitInstance
import kotlinx.coroutines.launch

import com.example.weatherapp.model.ForecastResponse


class WeatherViewModel : ViewModel() {

    // Current Weather
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    fun fetchWeather(location: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getWeather(location, apiKey)
                _weatherData.postValue(response)
            } catch (e: Exception) {
                // Handle error (e.g., log it or show a UI message)
            }
        }
    }

    // ✅ Forecast Data
    private val _forecastData = MutableLiveData<ForecastResponse>()
    val forecastData: LiveData<ForecastResponse> get() = _forecastData

    fun fetchForecast(zipCode: String, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getForecast(zipCode, apiKey)
                _forecastData.postValue(response)
            } catch (e: Exception) {
                // Handle forecast error (e.g., log it or show a UI message)
            }
        }
    }
}
