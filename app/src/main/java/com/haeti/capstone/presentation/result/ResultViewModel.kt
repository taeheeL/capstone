package com.haeti.capstone.presentation.result

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val result: Int = savedStateHandle["result"] ?: 0
}