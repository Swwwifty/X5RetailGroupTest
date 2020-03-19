package ru.egorkastr.x5retailtest.domain.usecase

import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository

/**
 * Use case implementation for shop list
 */
class ShopListInteractorImpl(private val shopRepository: ShopRepository) :
    ShopListInteractor {

    override suspend fun getShopList(): Result<List<ShopEntity>> {
        return shopRepository.getShopList()
    }

}