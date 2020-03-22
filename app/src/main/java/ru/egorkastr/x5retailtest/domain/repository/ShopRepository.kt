package ru.egorkastr.x5retailtest.domain.repository

import ru.egorkastr.x5retailtest.domain.entity.ShopDetailEntity
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity

/**
 * Repository for shops
 */
interface ShopRepository {

    /**
     * Get shop list from server. Returns result with list of the shops from remote server or result with error
     */
    suspend fun getShopList(): Result<List<ShopEntity>>

    /**
     * Get shop detail info for shop with id [shopId]. Returns result detail info from remote server or result with error
     */
    suspend fun getShopDetail(shopId: Int): Result<ShopDetailEntity>

}