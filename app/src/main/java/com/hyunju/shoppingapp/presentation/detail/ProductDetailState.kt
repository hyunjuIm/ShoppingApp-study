package com.hyunju.shoppingapp.presentation.detail

import com.hyunju.shoppingapp.data.entity.product.ProductEntity

sealed class ProductDetailState {

    object Uninitialized : ProductDetailState()

    object Loading : ProductDetailState()

    data class Success(
        val productEntity: ProductEntity
    ) : ProductDetailState()

    object Order : ProductDetailState()

    object Error : ProductDetailState()

}