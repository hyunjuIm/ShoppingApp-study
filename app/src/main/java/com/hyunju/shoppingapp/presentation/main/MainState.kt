package com.hyunju.shoppingapp.presentation.main

import com.hyunju.shoppingapp.data.entity.product.ProductEntity

sealed class MainState {

    object RefreshOrderList : MainState()

}