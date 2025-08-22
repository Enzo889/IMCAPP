package com.example.imc_app

data class IMCState(
    val category: Category = Category.Underweight,
    val weight: String = "",
    val height: String = "",
    val BMI: Float =  0f,
    val lowerWeightBound: Float = 0f,
    val higherWeightBound: Float = 0f,
    )