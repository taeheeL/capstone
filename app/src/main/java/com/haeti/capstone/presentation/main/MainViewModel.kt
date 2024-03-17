package com.haeti.capstone.presentation.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haeti.capstone.domain.repository.PredictRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val predictRepository: PredictRepository,
    private val savedStateHandle: SavedStateHandle
) : ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container =
        container<MainState, MainSideEffect>(MainState())

    fun updateHeight(height: String?) = intent {
        reduce {
            state.copy(height = height).validate()
        }
    }

    fun updateWeight(weight: String?) = intent {
        reduce {
            state.copy(weight = weight).validate()
        }
    }

    fun updateWaistline(waistline: String?) = intent {
        reduce {
            state.copy(waistline = waistline).validate()
        }
    }

    fun updateAge(age: Float) = intent {
        reduce {
            state.copy(age = age).validate()
        }
    }

    fun updateSex(index: Int) = intent {
        reduce {
            state.copy(sex = index)
        }
    }

    fun updateDrinking(index: Int) = intent {
        reduce {
            state.copy(drinking = index)
        }
    }

    fun updateSmoking(index: Int) = intent {
        reduce {
            state.copy(smoking = index + 1)
        }
    }

    fun predict() = intent {
        Timber.e("age: ${state.age}, waistline: ${state.waistline}, height: ${state.height}, weight: ${state.weight}, smoking: ${state.smoking}, drinking: ${state.drinking},")
        viewModelScope.launch {
            val result = predictRepository.postMainData(
                age = state.age,
                waistline = state.waistline?.toFloatOrNull() ?: 0f,
                height = state.height?.toFloatOrNull() ?: 0f,
                weight = state.weight?.toFloatOrNull() ?: 0f,
                smoking = state.smoking,
                drinking = state.drinking,
                sex = state.sex
            )

            if (result == -1) {
                postSideEffect(MainSideEffect.ErrorToast)
            } else {
                postSideEffect(MainSideEffect.NavigateToResult(result))
                savedStateHandle["result"] = result
            }
        }
    }
}

fun MainState.validate() = this.copy(
    isValid = height?.isNotEmpty() == true && weight?.isNotEmpty() == true && waistline?.isNotEmpty() == true
)
