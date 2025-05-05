package com.example.myweatherapp1.network // adjust this to match your actual package name

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface WeatherApiService {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,                  // City name
        @Query("appid") apiKey: String,            // API key
        @Query("units") units: String = "metric"   // Use "imperial" for Fahrenheit
    ): Response<WeatherResponse>
}
