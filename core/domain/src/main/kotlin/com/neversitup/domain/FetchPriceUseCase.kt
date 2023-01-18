package com.neversitup.domain

import com.neversitup.data.repository.PriceRepository
import com.neversitup.domain.base.UseCase
import com.neversitup.model.Price
import kotlinx.coroutines.flow.Flow

class FetchPriceUseCase(
    private val priceRepository: PriceRepository
) : UseCase<Long?, Price>() {
    override fun checkRequest(request: Long?) = request

    override suspend fun execute(request: Long?): Flow<Price> {
        return request?.let {
            priceRepository.getHistoryPriceById(request)
        } ?: run {
            priceRepository.getCurrentPrice()
        }
    }
}