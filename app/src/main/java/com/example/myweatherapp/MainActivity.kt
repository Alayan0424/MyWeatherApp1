package com.example.myweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import com.example.weatherapp.viewmodel.WeatherViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWeatherAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "weather") {
                    composable("weather") {
                        WeatherScreen( )
                    }
                    composable("forecast/{zipCode}") { backStackEntry ->
                        val zipCode = backStackEntry.arguments?.getString("zipCode") ?: ""
                        ForecastScreen(zipCode = zipCode)
                    }
                }
            }
        }

    }
}

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val weatherData = viewModel.weatherData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            viewModel.fetchWeather("lagos", "fd10af6783724efaf6f6de0e7cbfc1a8")
        }) {
            Text("Get Weather")
        }

        weatherData.value?.let { data ->
            Text("Temperature: ${data.main.temperature}°C")
            Text("Humidity: ${data.main.humidity}%")
            Text("Weather: ${data.weather[0].description}")
        }
    }
}
