package com.example.mvvm_navigation.navigator

import android.app.Application
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_navigation.Event
import com.example.mvvm_navigation.MainActivity
import com.example.mvvm_navigation.R
import com.example.mvvm_navigation.screens.base.BaseScreen


const val ARG_SCREEN = "ARG_SCREEN"

class MainNavigator(
    private val application: Application
) : AndroidViewModel(application), Navigator {

    val whenActivityActive = MainActivityActions()

    private val _result = MutableLiveData<Event<Any>>()
    val result: LiveData<Event<Any>> = _result

    override fun launch(screen: BaseScreen) = whenActivityActive {
        launchFragment(it, screen)
    }

    override fun goBack(result: Any?) = whenActivityActive {
        if (result != null) {
            _result.value = Event(result)
        }
        it.onBackPressed()
    }

    override fun toast(message: Int) {
        Toast.makeText(getApplication(), message, Toast.LENGTH_SHORT).show()
    }

    override fun getString(message: Int): String {
        return getApplication<Application>().getString(message)
    }

    override fun onCleared() {
        super.onCleared()
        whenActivityActive.onClearActions()
    }

    fun launchFragment(activity: MainActivity, screen: BaseScreen, addToBackStack: Boolean = true) {
        val fragment = screen.javaClass.enclosingClass.newInstance() as Fragment
        fragment.arguments = bundleOf(ARG_SCREEN to screen)
        val transaction = activity.supportFragmentManager.beginTransaction()
        if (addToBackStack) transaction.addToBackStack(null)
        transaction
            .replace(R.id.fragmentContainer, fragment)
            .commit()

    }

}