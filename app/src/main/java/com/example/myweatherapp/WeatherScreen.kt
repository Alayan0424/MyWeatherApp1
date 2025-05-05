import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.weatherapp.viewmodel.WeatherViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myweatherapp.R


@Composable
fun WeatherScreen(
    navController: NavHostController,
    viewModel: WeatherViewModel = viewModel()


) {
    var zipCode by remember { mutableStateOf("") }
    val weatherData = viewModel.weatherData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        OutlinedTextField(
            value = zipCode,
            onValueChange = {
                if (it.length <= 5 && it.all { char -> char.isDigit() }) {
                    zipCode = it
                }
            },
            label = { Text("Enter Zip Code") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.fetchWeather(zipCode, "fd10af6783724efaf6f6de0e7cbfc1a8")
        }) { (Button(onClick = {

        }) {
                Text(text = stringResource(R.string.get_weather_button))
            }
            )
        }

        Button(onClick = {
            navController.navigate("forecast/$zipCode")
        }) {
            Text("See 16-day Forecast")
        }

        Spacer(modifier = Modifier.height(16.dp))

        weatherData.value?.let { data ->
            Text("Temperature: ${data.main.temperature}°C")
            Text(Text(text = stringResource(R.string.humidity, data.main.humidity))
                    Text(text = stringResource(R.string.weather_label, data.weather[0].description))

                val iconUrl = "https://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png"
            AsyncImage(
                model = iconUrl,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )

        }
    }
}





