package com.example.imc_app

import androidx.compose.ui.graphics.Color
import com.example.imc_app.ui.theme.Blue
import com.example.imc_app.ui.theme.Green
import com.example.imc_app.ui.theme.Orange
import com.example.imc_app.ui.theme.Red

enum class Category(val color: Color) {
    Underweight(Blue),
    Normal(Green),
    OverWeight(Orange),
    Obese(Red),
}