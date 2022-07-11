package com.hyunju.shoppingapp.domain

import com.hyunju.shoppingapp.data.entity.product.ProductEntity
import com.hyunju.shoppingapp.data.repository.ProductRepository

class GetOrderedProductListUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getLocalProductList()
    }
}