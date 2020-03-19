package ru.egorkastr.x5retailtest.domain.usecase

import ru.egorkastr.x5retailtest.domain.entity.ShopEntity

/**
 * Use case interface for shop list
 */
interface ShopListInteractor {

    /**
     * Get shop list. Returns result with list of the shops or result with error
     */
    suspend fun getShopList(): Result<List<ShopEntity>>

}