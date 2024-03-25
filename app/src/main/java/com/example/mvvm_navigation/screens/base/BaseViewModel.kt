package com.example.mvvm_navigation.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class BaseViewModel: ViewModel() {

    open fun onResult(result: Any) {}
}