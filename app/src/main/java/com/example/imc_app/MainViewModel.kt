package com.example.imc_app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var state by mutableStateOf(IMCState())

    private fun calculateBmi() {
        state = if(state.height.isNotBlank() && state.weight.isNotBlank()) {
            val  heightInMeters = state.height.toFloat() / 100
            val newBmi = state.weight.toFloat() / (heightInMeters * heightInMeters)
            calculateWeightBounds()
            val cat = findCategory(newBmi)
            state.copy(
                BMI = newBmi,
                category = cat
            )
        } else {
            state.copy(
                BMI = 0f,
                higherWeightBound = 0f,
                lowerWeightBound = 0f,
                category = Category.Underweight
            )
        }
    }

    private fun calculateWeightBounds() {
        val heightInMeters = state.height.toFloat()/100f
        val lWeight = 18.6f * (heightInMeters * heightInMeters)
        val hWeight = 24.9f * (heightInMeters * heightInMeters)
        state = state.copy(
            lowerWeightBound = lWeight,
            higherWeightBound = hWeight
        )
    }

    private fun findCategory(bmi: Float): Category {
        return if ( bmi <= 18.5 ){
            Category.Underweight
        } else if ( bmi <= 24.9 ) {
            Category.Normal
        } else if ( bmi <= 29.9 ) {
            Category.OverWeight
        } else {
            Category.Obese
        }
    }

    fun changeWeight (weight: String) {
        state = state.copy(
            weight = weight
        )
        calculateBmi()
    }

    fun changeHeight(height: String) {
        state = state.copy(
            height = height
        )
        calculateBmi()
    }
}