package com.example.lifecyclelogger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "LifecycleLogger"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity - onCreate")

        setContent {
            MainScreen(
                onSecondScreenClick = {
                    val intent = Intent(this, SecondActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume")
    }

    override fun onPause() {
        Log.d(TAG, "MainActivity - onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "MainActivity - onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "MainActivity - onDestroy")
        super.onDestroy()
    }
}

@Composable
fun MainScreen(
    onSecondScreenClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Lifecycle Logger",
            fontSize = 30.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Multi-Screen Activity Lifecycle Demo",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onSecondScreenClick
        ) {
            Text("Go to Second Screen")
        }
    }
}