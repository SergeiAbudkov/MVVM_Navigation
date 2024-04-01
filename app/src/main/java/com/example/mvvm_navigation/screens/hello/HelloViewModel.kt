package com.example.mvvm_navigation.screens.hello

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_navigation.R
import com.example.mvvm_navigation.navigator.Navigator
import com.example.mvvm_navigation.screens.base.BaseViewModel
import com.example.mvvm_navigation.screens.edit.EditFragment
import com.example.mvvm_navigation.screens.hello.HelloFragment.Screen

class HelloViewModel(
    private val navigator: Navigator,
    screen: Screen
) : BaseViewModel() {

    private val _currentMessageLiveData = MutableLiveData<String>()
    val currentMessageLiveData: LiveData<String> = _currentMessageLiveData

    init {
        _currentMessageLiveData.value = navigator.getString(R.string.hello_world)
    }

    override fun onResult(result: Any) {
        if (result is String) {
            _currentMessageLiveData.value = result
        }
    }

    fun onEditPressed() {
        navigator.launch(EditFragment.Screen(initialValue = currentMessageLiveData.value!!))
    }
}