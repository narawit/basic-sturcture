package com.neversitup.sturcture.ui.main

import androidx.lifecycle.lifecycleScope
import com.neversitup.app.databinding.ActivityMainBinding
import com.neversitup.common.BaseActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModel()

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        with(binding) {
            btnCurrentPrice.setOnClickListener {
                viewModel.execute.fetchCurrentPrice()
            }
            btnHistoryPrice.setOnClickListener {
                viewModel.execute.fetchHistoryPrice()
            }
        }
    }

    override fun observer() {
        viewModel.flows.onEach {
            binding.tvText.append("\n")
            when (it) {
                is MainViewModel.Event.CurrentPrice -> {
                    binding.tvText.append("Event.CurrentPrice\n")
                    binding.tvText.append("${Json.encodeToString(it.data)}")
                }
                is MainViewModel.Event.HistoryPrice -> {
                    binding.tvText.append("Event.HistoryPrice\n")
                    binding.tvText.append("${Json.encodeToString(it.data)}")
                }
                is MainViewModel.Event.Failure -> {
                    binding.tvText.append("Event.Failure")
                    binding.tvText.append("${it.error?.message}")
                }
                is MainViewModel.Event.Loading -> {
                    binding.tvText.append("Event.Loading")
                }
            }
        }.launchIn(lifecycleScope)
    }
}