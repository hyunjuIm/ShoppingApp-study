package com.hyunju.shoppingapp.domain

import com.hyunju.shoppingapp.data.entity.product.ProductEntity
import com.hyunju.shoppingapp.data.repository.ProductRepository

class OrderProductItemUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(productEntity: ProductEntity): Long {
        return productRepository.insertProductItem(productEntity)
    }
}