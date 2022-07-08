package com.hyunju.shoppingapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hyunju.shoppingapp.data.entity.product.ProductEntity
import com.hyunju.shoppingapp.domain.GetProductItemUseCase
import com.hyunju.shoppingapp.domain.OrderProductItemUseCase
import com.hyunju.shoppingapp.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

internal class ProductDetailViewModel(
    private val productId: Long,
    private val getProductItemUseCase: GetProductItemUseCase,
    private val orderProductItemUseCase: OrderProductItemUseCase
) : BaseViewModel() {

    private var _productDetailStateLiveData =
        MutableLiveData<ProductDetailState>(ProductDetailState.Uninitialized)
    val productDetailStateLiveData: LiveData<ProductDetailState> = _productDetailStateLiveData

    private lateinit var productEntity: ProductEntity

    override fun fetchDate(): Job = viewModelScope.launch {
        setState(ProductDetailState.Loading)
        getProductItemUseCase(productId)?.let { product ->
            productEntity = product
            setState(
                ProductDetailState.Success(product)
            )
        } ?: run {
            setState(ProductDetailState.Error)
        }
    }

    fun orderProduct() = viewModelScope.launch {
        if (::productEntity.isInitialized) {
            val productId = orderProductItemUseCase(productEntity)
            if (productEntity.id == productId) {
                setState(ProductDetailState.Order)
            }
        } else {
            setState(ProductDetailState.Error)
        }
    }

    private fun setState(state: ProductDetailState) {
        _productDetailStateLiveData.postValue(state)
    }

}