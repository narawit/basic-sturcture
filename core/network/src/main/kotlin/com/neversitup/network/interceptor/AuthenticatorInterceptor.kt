package com.neversitup.network.interceptor

import com.neversitup.datastore.AppDataStore
import com.neversitup.datastore.PreferenceStorage
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticatorInterceptor(
    private val preferenceStorage: PreferenceStorage
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder().apply {
                val token = preferenceStorage.getString(AppDataStore.AccessToken, "")
                if (token.isNotEmpty())
                    addHeader("Authorization", "Bearer $token")
            }.build()
        )
    }
}