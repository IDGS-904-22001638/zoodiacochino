package com.example.zoodiacochino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.zoodiacochino.ui.theme.ZoodiacochinoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZoodiacochinoTheme {
                // Inicia la aplicación
                AppZodiacoChino()
            }
        }
    }
}