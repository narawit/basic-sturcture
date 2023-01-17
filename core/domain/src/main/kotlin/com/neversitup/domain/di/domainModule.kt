package com.neversitup.domain.di

import com.neversitup.domain.FetchPriceUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { FetchPriceUseCase(get()) }
}