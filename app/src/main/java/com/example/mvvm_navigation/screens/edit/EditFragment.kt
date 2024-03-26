package com.example.mvvm_navigation.screens.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_navigation.databinding.FragmentEditBinding
import com.example.mvvm_navigation.screens.base.BaseFragment
import com.example.mvvm_navigation.screens.base.BaseScreen
import com.example.mvvm_navigation.screens.base.BaseViewModel
import com.example.mvvm_navigation.screens.base.screenViewModel

class EditFragment : BaseFragment() {
    private lateinit var binding: FragmentEditBinding

    class Screen(
        val initialValue: String
    ) : BaseScreen

    override val viewModel: EditViewModel by screenViewModel<EditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(layoutInflater, container, false)

        viewModel.initialMessageEvent.observe(viewLifecycleOwner) {
            it.getValue()?.let { message -> binding.valueEditText.setText(message) }
        }

        binding.saveButton.setOnClickListener {
            viewModel.onSavePressed(binding.valueEditText.text.toString())
        }

        binding.cancelButton.setOnClickListener {
            viewModel.onCancelPressed()
        }

        return binding.root
    }


}