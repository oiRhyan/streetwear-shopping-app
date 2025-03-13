package com.dev.rhyan.stutwear.data.di

import com.dev.rhyan.stutwear.data.repository.ProductRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
     single {
          ProductRepository(get())
     }
}