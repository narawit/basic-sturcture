package com.neversitup.sturcture.ui.main

import androidx.lifecycle.viewModelScope
import com.neversitup.common.extension.onComplete
import com.neversitup.data.repository.PriceRepository
import com.neversitup.domain.FetchPriceUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class MainViewModelImpl(
    private val priceRepository: PriceRepository,
    private val FetchPriceUseCase: FetchPriceUseCase
) : MainViewModel(), MainViewModel.Execute {

    override val execute: Execute
        get() = this

    private val channel = Channel<Event>()
    override val flows = channel.receiveAsFlow()

    override fun fetchCurrentPrice() {
        priceRepository.getCurrentPrice()
            .onComplete(
                scope = viewModelScope,
                action = { channel.send(Event.CurrentPrice(it)) },
                failure = { channel.send(Event.Failure(it)) },
                loading = { channel.send(Event.Loading) }
            )
    }

    override fun fetchHistoryPrice() {
        priceRepository.getHistoryPrice()
            .onComplete(
                scope = viewModelScope,
                action = { channel.send(Event.HistoryPrice(it)) },
                failure = { channel.send(Event.Failure(it)) },
                loading = { channel.send(Event.Loading) }
            )
    }
}