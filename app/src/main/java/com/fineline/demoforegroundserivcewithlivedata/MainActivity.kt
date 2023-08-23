package com.fineline.demoforegroundserivcewithlivedata

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fineline.demoforegroundserivcewithlivedata.ui.theme.DemoForegroundSerivceWithLiveDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoForegroundSerivceWithLiveDataTheme {
               Column(
                   modifier = Modifier.fillMaxSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   Button(
                       onClick = {
                           Intent(applicationContext, ForegroundService::class.java).also {
                               it.action = ForegroundService.Actions.START.toString()
                               startService(it)
                           }
                       }
                   ) {
                       Text(text = "Start service")
                   }
                   Button(
                       onClick = {

                           Intent(applicationContext, ForegroundService::class.java).also {
                               it.action = ForegroundService.Actions.STOP.toString()
                               startService(it)
                           }
                       }
                   ) {
                       Text(text = "Stop service")
                   }
               }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DemoForegroundSerivceWithLiveDataTheme {
        Greeting("Android")
    }
}