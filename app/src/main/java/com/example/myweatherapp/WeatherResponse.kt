package com.example.weatherapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("main")
    val main: Main,
    @SerialName("weather")
    val weather: List<Weather>
)

@Serializable
data class Main(
    @SerialName("temp")
    val temperature: Double,
    @SerialName("humidity")
    val humidity: Int
)

@Serializable
data class Weather(
    @SerialName("description")
    val description: String,
    @SerialName("icon")
    val icon: String
)
