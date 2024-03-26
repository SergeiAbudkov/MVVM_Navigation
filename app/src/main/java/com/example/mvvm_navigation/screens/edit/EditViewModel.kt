package com.example.mvvm_navigation.screens.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_navigation.Event
import com.example.mvvm_navigation.R
import com.example.mvvm_navigation.navigator.Navigator
import com.example.mvvm_navigation.screens.base.BaseViewModel
import com.example.mvvm_navigation.screens.edit.EditFragment.Screen

class EditViewModel(
    private val navigator: Navigator,
    private val screen: Screen
) : BaseViewModel() {

    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val initialMessageEvent: LiveData<Event<String>> = _initialMessageEvent

    init {
        initialValue()
    }

    private fun initialValue() {
        _initialMessageEvent.value = Event(screen.initialValue)
    }

    fun onSavePressed(message: String) {
        if (message.isBlank()) {
            navigator.toast(R.string.empty_message)
            return
        } else {
            navigator.goBack(message)

        }
    }

    fun onCancelPressed() {
        navigator.goBack()
    }


}