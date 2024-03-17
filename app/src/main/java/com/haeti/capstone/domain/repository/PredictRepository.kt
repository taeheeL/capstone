package com.haeti.capstone.domain.repository

interface PredictRepository {
    suspend fun postMainData(
        height: Float,
        weight: Float,
        waistline: Float,
        age: Float,
        sex: Int,
        drinking: Int,
        smoking: Int,
    ): Int
}