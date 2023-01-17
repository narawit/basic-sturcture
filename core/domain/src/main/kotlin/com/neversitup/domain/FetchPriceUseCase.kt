package com.neversitup.domain

import com.neversitup.data.repository.PriceRepository
import com.neversitup.model.Price
import kotlinx.coroutines.flow.Flow

class FetchPriceUseCase(
    private val priceRepository: PriceRepository
) {
    operator fun invoke(id: Long? = null): Flow<Price> =
        id?.let {
            priceRepository.getHistoryPriceById(id)
        } ?: run {
            priceRepository.getCurrentPrice()
        }
}