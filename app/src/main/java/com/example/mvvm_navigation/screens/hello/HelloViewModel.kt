package com.example.mvvm_navigation.screens.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_navigation.navigator.Navigator
import com.example.mvvm_navigation.screens.base.BaseViewModel

class HelloViewModel(
    val navigator: Navigator,
    screen: HelloFragment.Screen
) : BaseViewModel() {

 private val _currentMessageValue = MutableLiveData<String>()
 val currentMessageValue: LiveData<String> = _currentMessageValue

    fun onEditPressed() {

    }
}