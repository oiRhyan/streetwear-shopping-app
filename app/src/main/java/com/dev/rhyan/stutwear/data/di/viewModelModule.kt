package com.dev.rhyan.stutwear.data.di

import com.dev.rhyan.stutwear.presentation.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}