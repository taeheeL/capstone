package com.haeti.capstone.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PredictRequestDto(
    @SerialName("연령")
    val age: Int,
    @SerialName("허리둘레")
    val waistline: Int,
    @SerialName("흡연상태")
    val smoking: Int,
    @SerialName("음주여부")
    val drinking: Int,
    @SerialName("BMI")
    val bmi: Int,
    @SerialName("남성")
    val male: Int = 0,
    @SerialName("여성")
    val female: Int = 0,
)

@Serializable
data class PredictResponseDto(
    @SerialName("predicted")
    val result: Int
)
