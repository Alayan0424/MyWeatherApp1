package com.example.weatherapp.network

import com.example.myweatherapp.ForecastResponse
import com.example.weatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String
    ): WeatherResponse

    @GET("forecast")
    suspend fun getForecast(
        @Query("zip") zipCode: String,
        @Query("appid") apiKey: String
    ): ForecastResponse

}
