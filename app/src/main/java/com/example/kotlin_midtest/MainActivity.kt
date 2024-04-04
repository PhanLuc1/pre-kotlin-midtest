package com.example.kotlin_midtest

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin_midtest.ui.theme.KotlinmidtestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinmidtestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(){
    Column {
        ColorTextField()
    }
}
@Composable
fun ColorTextField(){
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var redValue by remember { mutableStateOf(0)}
            var greenValue by remember { mutableStateOf(0)}
            var blueValue by remember { mutableStateOf(0)}

            // TextFields for red, green, and blue values
            RGBTextField("Red", redValue){redValue = it}
            RGBTextField("Green", greenValue){greenValue = it}
            RGBTextField("Blue", blueValue) {blueValue = it}

            Spacer(modifier = Modifier.height(16.dp))

            // Rectangle showing the selected color
            Box(
                modifier = Modifier
                    .size(200.dp, 100.dp)
                    .background(Color(redValue, greenValue,blueValue))
            )
        }
    }
}
@Composable
fun RGBTextField(label: String, value: Int, onValueChange: (Int) -> Unit) {
    OutlinedTextField(
        value = if (value == 0) "" else value.toString(),
        //value = value.toString(),
        onValueChange = {
            val newValue = it.toIntOrNull() ?: 0
            onValueChange(newValue.coerceIn(0, 255))
        },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KotlinmidtestTheme {
        HomeScreen()
    }
}