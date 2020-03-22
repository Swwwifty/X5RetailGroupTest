package ru.egorkastr.x5retailtest.domain.usecase

import ru.egorkastr.x5retailtest.domain.entity.ShopDetailEntity
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository

/**
 * Use case implementation for shop feature
 */
class ShopInteractorImpl(private val shopRepository: ShopRepository) :
    ShopInteractor {

    override suspend fun getShopList(): Result<List<ShopEntity>> {
        return shopRepository.getShopList()
    }

    override suspend fun getShopDetail(shopId: Int): Result<ShopDetailEntity> {
        return shopRepository.getShopDetail(shopId)
    }

}