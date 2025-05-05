package com.example.weatherapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    @SerialName("list")
    val list: List<DailyForecast>
)

@Serializable
data class DailyForecast(
    @SerialName("dt_txt")
    val date: String,

    @SerialName("main")
    val main: MainForecast,

    @SerialName("weather")
    val weather: List<WeatherCondition>
)

@Serializable
data class MainForecast(
    @SerialName("temp")
    val temp: Float
)

@Serializable
data class WeatherCondition(
    @SerialName("description")
    val description: String
)
