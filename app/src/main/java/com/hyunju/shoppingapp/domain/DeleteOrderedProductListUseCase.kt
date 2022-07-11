package com.hyunju.shoppingapp.domain

import com.hyunju.shoppingapp.data.repository.ProductRepository

internal class DeleteOrderedProductListUseCase(
    private val productRepository: ProductRepository
) : UseCase {

    suspend operator fun invoke() {
        return productRepository.deleteAll()
    }

}