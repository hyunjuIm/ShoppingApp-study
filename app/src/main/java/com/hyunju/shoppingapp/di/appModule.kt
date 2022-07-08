package com.hyunju.shoppingapp.di

import com.hyunju.shoppingapp.data.db.provideDB
import com.hyunju.shoppingapp.data.db.provideToDoDao
import com.hyunju.shoppingapp.data.network.buildOkHttpClient
import com.hyunju.shoppingapp.data.network.provideGsonConverterFactory
import com.hyunju.shoppingapp.data.network.provideProductApiService
import com.hyunju.shoppingapp.data.network.provideProductRetrofit
import com.hyunju.shoppingapp.data.repository.DefaultProductRepository
import com.hyunju.shoppingapp.data.repository.ProductRepository
import com.hyunju.shoppingapp.domain.GetProductItemUseCase
import com.hyunju.shoppingapp.domain.GetProductListUseCase
import com.hyunju.shoppingapp.domain.OrderProductItemUseCase
import com.hyunju.shoppingapp.presentation.detail.ProductDetailViewModel
import com.hyunju.shoppingapp.presentation.list.ProductListViewModel
import com.hyunju.shoppingapp.presentation.main.MainViewModel
import com.hyunju.shoppingapp.presentation.profile.ProfileViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // ViewModels
    viewModel { MainViewModel() }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProfileViewModel() }
    viewModel { (productId: Long) -> ProductDetailViewModel(productId, get(), get()) }

    // Coroutines Dispatcher
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    // UseCases
    factory { GetProductItemUseCase(get()) }
    factory { GetProductListUseCase(get()) }
    factory { OrderProductItemUseCase(get()) }

    // Repositories
    single<ProductRepository> { DefaultProductRepository(get(), get(), get()) }

    single { provideGsonConverterFactory() }
    single { buildOkHttpClient() }
    single { provideProductRetrofit(get(), get()) }
    single { provideProductApiService(get()) }

    // Database
    single { provideDB(androidApplication()) }
    single { provideToDoDao(get()) }
}