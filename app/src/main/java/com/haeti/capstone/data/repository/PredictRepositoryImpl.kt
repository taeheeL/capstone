package com.haeti.capstone.data.repository

import com.haeti.capstone.data.dto.PredictRequestDto
import com.haeti.capstone.data.service.MainService
import com.haeti.capstone.domain.repository.PredictRepository
import timber.log.Timber
import javax.inject.Inject
import kotlin.math.round

class PredictRepositoryImpl @Inject constructor(
    private val mainService: MainService
) : PredictRepository {
    override suspend fun postMainData(
        height: Float,
        weight: Float,
        waistline: Float,
        age: Float,
        sex: Int,
        drinking: Int,
        smoking: Int
    ): Int {

        val heightInMeters = height / 100
        val bmi = round(weight / (heightInMeters * heightInMeters))

        Timber.e("age: $age, waistline: $waistline, height: $height, weight: $weight, smoking: $smoking, drinking: $drinking, bmi: $bmi")

        kotlin.runCatching {
            mainService.postMainData(
                PredictRequestDto(
                    age = round(age).toInt(),
                    waistline = round(waistline).toInt(),
                    smoking = smoking,
                    drinking = drinking,
                    bmi = bmi.toInt(),
                    male = if (sex == 0) 1 else 0,
                    female = if (sex == 1) 1 else 0
                )
            )
        }.fold(
            onSuccess = {
                Timber.e("result: ${it.result}")
                return it.result
            },
            onFailure = {
                Timber.e("error: ${it.message}")
                return -1
            })
    }

}
