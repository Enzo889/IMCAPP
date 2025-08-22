package com.example.imc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imc_app.ui.theme.BackGround
import com.example.imc_app.ui.theme.IMCAPPTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMCAPPTheme {
                val viewModel = MainViewModel()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = BackGround,
                        darkIcons = false
                    )
                }

                AppDrawer(viewModel = viewModel) // 👈 ahora usamos el Drawer
            }
        }
    }
}
