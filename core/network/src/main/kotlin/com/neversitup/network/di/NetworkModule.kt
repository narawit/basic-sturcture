package com.neversitup.network.di

import com.neversitup.network.api.CoinApi
import com.neversitup.network.interceptor.AuthenticatorInterceptor
import com.neversitup.network.retrofit.RetrofitBuilder
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import org.koin.dsl.module

val networkModule = module {
    single { Json { ignoreUnknownKeys = true } }

    single<Interceptor> { AuthenticatorInterceptor(get()) }

    single<CoinApi> {
        RetrofitBuilder.build(RetrofitBuilder.BaseUrl, get(), getAll(), get())
    }
}