package com.haeti.capstone.data.service

import com.haeti.capstone.data.dto.PredictRequestDto
import com.haeti.capstone.data.dto.PredictResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface MainService {
    @POST("/predict")
    suspend fun postMainData(
        @Body predictRequestDto: PredictRequestDto
    ): PredictResponseDto
}