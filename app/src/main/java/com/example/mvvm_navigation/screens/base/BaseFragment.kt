package com.example.mvvm_navigation.screens.base

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract val viewModel: BaseViewModel

}