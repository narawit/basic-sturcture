package com.neversitup.data.di

import com.neversitup.data.repository.PriceRepository
import com.neversitup.data.repository.PriceRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<PriceRepository> { PriceRepositoryImpl(get(), get()) }
}