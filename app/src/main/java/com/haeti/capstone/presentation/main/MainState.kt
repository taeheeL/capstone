package com.haeti.capstone.presentation.main

data class MainState(
    val height: String? = null,
    val weight: String? = null,
    val waistline: String? = null,
    val age: Float = 0f,
    val sex: Int = 0,
    val drinking: Int = 0,
    val smoking: Int = 0,
    val isValid: Boolean = false,
)