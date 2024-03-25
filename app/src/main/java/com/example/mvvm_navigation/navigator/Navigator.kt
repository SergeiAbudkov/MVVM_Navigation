package com.example.mvvm_navigation.navigator

import androidx.annotation.StringRes
import com.example.mvvm_navigation.screens.base.BaseScreen

interface Navigator {

    fun launch(screen: BaseScreen)

    fun goBack(result: Any? = null)

    fun toast(@StringRes message: Int)

    fun getString(@StringRes message: Int): String

}