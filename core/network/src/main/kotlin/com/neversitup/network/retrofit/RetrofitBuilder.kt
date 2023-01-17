package com.neversitup.network.retrofit

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.neversitup.network.BuildConfig
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    const val BaseUrl = BuildConfig.BACKEND_URL
    private const val ConnectTimeout = 10L //SECONDS
    private const val ReadTimeout = 90L //SECONDS

    fun createOkHttpClient(context: Context, interceptors: List<Interceptor>? = null) =
        OkHttpClient.Builder()
            .apply {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
                    addInterceptor(getChuckerInterceptor(context))
                }
                interceptors?.forEach { interceptor -> addInterceptor(interceptor) }

                connectTimeout(ConnectTimeout, TimeUnit.SECONDS)
                readTimeout(ReadTimeout, TimeUnit.SECONDS)
            }
            .build()

    private fun getChuckerInterceptor(context: Context): ChuckerInterceptor {
        val chuckerCollector = ChuckerCollector(
            context = context,
            showNotification = true,
            retentionPeriod = RetentionManager.Period.ONE_HOUR
        )

        return ChuckerInterceptor.Builder(context)
            .collector(chuckerCollector)
            .build()
    }

    inline fun <reified T> build(
        baseUrl: String = BaseUrl,
        context: Context,
        interceptors: List<Interceptor>? = null,
        json: Json
    ): T {
        val builder = Retrofit.Builder()
            .client(createOkHttpClient(context, interceptors))
            .baseUrl(baseUrl)

        builder.addConverterFactory(
            @OptIn(ExperimentalSerializationApi::class)
            json.asConverterFactory("application/json".toMediaType())
        )

        return builder.build()
            .create(T::class.java)
    }
}