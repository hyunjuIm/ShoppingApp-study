package com.hyunju.shoppingapp.domain

import com.hyunju.shoppingapp.data.entity.product.ProductEntity
import com.hyunju.shoppingapp.data.repository.ProductRepository

class GetProductItemUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke(productId: Long): ProductEntity? {
        return productRepository.getProductItem(productId)
    }
}