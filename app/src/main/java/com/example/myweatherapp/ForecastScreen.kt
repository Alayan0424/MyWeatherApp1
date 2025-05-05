package com.example.myweatherapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.viewmodel.WeatherViewModel

import com.example.weatherapp.model.DailyForecast
import com.example.weatherapp.model.MainForecast
import com.example.weatherapp.model.WeatherCondition
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForecastScreen(
    zipCode: String,
    viewModel: WeatherViewModel = viewModel()
) {
    val forecast = viewModel.forecastData.observeAsState()

    LaunchedEffect(zipCode) {
        viewModel.fetchForecast(zipCode, "fd10af6783724efaf6f6de0e7cbfc1a8")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("16-Day Forecast") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Forecast for Zip Code: $zipCode",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            forecast.value?.let { response ->
                LazyColumn {
                    items(response.list) { day ->
                        Column(modifier = Modifier.padding(vertical = 8.dp)) {
                            Text("Date: ${day.date}")
                            Text("Temp: ${day.main.temp}°C")
                            Text("Condition: ${day.weather.firstOrNull()?.description ?: "N/A"}")
                            Divider(modifier = Modifier.padding(vertical = 8.dp))
                        }
                    }
                }
            } ?: Text("Loading forecast...")
        }
    }
}

