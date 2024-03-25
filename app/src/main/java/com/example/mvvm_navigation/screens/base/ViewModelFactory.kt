package com.example.mvvm_navigation.screens.base

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            BaseViewModel::class.java -> {
                BaseViewModel()
            } else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}

inline fun <reified VM : ViewModel> BaseFragment.screenViewModel() = viewModels<VM>{
    ViewModelFactory()
}
