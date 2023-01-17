package com.neversitup.sturcture.ui.main

import androidx.lifecycle.ViewModel
import com.neversitup.model.Price
import kotlinx.coroutines.flow.Flow

abstract class MainViewModel : ViewModel() {
    abstract val execute: Execute
    abstract val flows: Flow<Event>

    sealed class Event {
        object Loading : Event()
        data class Failure(val error: Throwable?) : Event()
        data class CurrentPrice(val data: Price?) : Event()
        data class HistoryPrice(val data: List<Price>) : Event()
    }

    interface Execute {
        fun fetchCurrentPrice()
        fun fetchHistoryPrice()
    }
}