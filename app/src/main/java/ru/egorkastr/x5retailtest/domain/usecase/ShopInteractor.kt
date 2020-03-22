package ru.egorkastr.x5retailtest.domain.usecase

import ru.egorkastr.x5retailtest.domain.entity.ShopDetailEntity
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity

/**
 * Use case interface for shop feature
 */
interface ShopInteractor {

    /**
     * Get shop list. Returns result with list of the shops or result with error
     */
    suspend fun getShopList(): Result<List<ShopEntity>>

    /**
     * Get shop detail info. Returns result with shop detail info or result with error
     */
    suspend fun getShopDetail(shopId: Int): Result<ShopDetailEntity>

}