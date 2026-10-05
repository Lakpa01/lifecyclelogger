package com.example.lifecyclelogger

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class SecondActivity : ComponentActivity() {

    companion object {
        private const val TAG = "LifecycleLogger"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SecondActivity - onCreate")

        setContent {
            SecondScreen(
                onBackClick = {
                    finish()
                }
            )
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity - onResume")
    }

    override fun onPause() {
        Log.d(TAG, "SecondActivity - onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "SecondActivity - onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "SecondActivity - onDestroy")
        super.onDestroy()
    }
}

@androidx.compose.runtime.Composable
fun SecondScreen(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Second Screen"
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Back to Main Screen")
        }
    }
}