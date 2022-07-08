package com.hyunju.shoppingapp.domain

import com.hyunju.shoppingapp.data.entity.product.ProductEntity
import com.hyunju.shoppingapp.data.repository.ProductRepository

class GetProductListUseCase(
    private val productRepository: ProductRepository
) {

    suspend operator fun invoke(): List<ProductEntity> {
        return productRepository.getProductList()
    }
}