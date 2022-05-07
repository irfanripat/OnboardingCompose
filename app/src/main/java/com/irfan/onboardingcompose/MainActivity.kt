package com.irfan.onboardingcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.irfan.onboardingcompose.ui.theme.OnboardingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnboardingComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    OnboardScreen(modifier = Modifier.background(Color.White))
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun DefaultPreview() {
    OnboardingComposeTheme {
        OnboardScreen(modifier = Modifier.background(Color.White))
    }
}