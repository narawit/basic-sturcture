package com.neversitup.domain

import com.neversitup.data.repository.PriceRepository
import com.neversitup.model.Price
import kotlinx.coroutines.flow.Flow

class FetchPriceEveryMinUseCase(
    private val priceRepository: PriceRepository
) {
    suspend operator fun invoke(): Flow<Price> {
        return priceRepository.getCurrentPrice()
    }
}