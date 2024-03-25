package com.example.mvvm_navigation.screens.hello

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_navigation.databinding.FragmentHelloBinding
import com.example.mvvm_navigation.screens.base.BaseFragment
import com.example.mvvm_navigation.screens.base.BaseScreen
import com.example.mvvm_navigation.screens.base.BaseViewModel
import com.example.mvvm_navigation.screens.base.screenViewModel

class HelloFragment : BaseFragment() {

    class Screen: BaseScreen

    private lateinit var binding: FragmentHelloBinding

    override val viewModel: BaseViewModel by screenViewModel<HelloViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelloBinding.inflate(layoutInflater, container, false)




        return binding.root
    }
}