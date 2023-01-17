package com.neversitup.sturcture

import android.app.Application
import com.neversitup.data.di.dataModule
import com.neversitup.database.di.databaseModule
import com.neversitup.datastore.di.dataStoreModule
import com.neversitup.domain.di.domainModule
import com.neversitup.network.di.networkModule
import com.neversitup.sturcture.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(
                dataStoreModule,
                networkModule,
                databaseModule,
                dataModule,
                domainModule,
                module
            )
        }

    }
}