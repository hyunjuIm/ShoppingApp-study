package com.hyunju.shoppingapp.presentation.list

import com.hyunju.shoppingapp.data.entity.product.ProductEntity

sealed class ProductListState {

    object Uninitialized : ProductListState()

    object Loading : ProductListState()

    data class Success(
        val productList: List<ProductEntity>
    ) : ProductListState()

    object Error : ProductListState()

}