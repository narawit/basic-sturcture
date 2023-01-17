package com.neversitup.sturcture.di

import com.neversitup.sturcture.ui.main.MainViewModel
import com.neversitup.sturcture.ui.main.MainViewModelImpl
import org.koin.dsl.module

val module = module {
    single<MainViewModel> { MainViewModelImpl(get()) }
}