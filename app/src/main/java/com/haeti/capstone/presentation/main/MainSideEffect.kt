package com.haeti.capstone.presentation.main

sealed class MainSideEffect {
    class NavigateToResult(val result: Int) : MainSideEffect()
    data object ErrorToast : MainSideEffect()
}