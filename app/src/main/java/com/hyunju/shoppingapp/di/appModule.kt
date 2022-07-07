package com.hyunju.shoppingapp.di

import com.hyunju.shoppingapp.data.network.buildOkHttpClient
import com.hyunju.shoppingapp.data.network.provideGsonConverterFactory
import com.hyunju.shoppingapp.data.network.provideProductApiService
import com.hyunju.shoppingapp.data.network.provideProductRetrofit
import com.hyunju.shoppingapp.data.repository.DefaultProductRepository
import com.hyunju.shoppingapp.data.repository.ProductRepository
import com.hyunju.shoppingapp.domain.GetProductItemUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {

    single { Dispatchers.Main }
    single { Dispatchers.IO }

    factory { GetProductItemUseCase(get()) }

    single<ProductRepository> { DefaultProductRepository(get(), get()) }

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { provideProductRetrofit(get(), get()) }
    single { provideProductApiService(get()) }
}