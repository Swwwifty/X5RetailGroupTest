package ru.egorkastr.x5retailtest.data.repository

import kotlinx.coroutines.delay
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository

/**
 * Remote shop repository implementation
 */
class ShopRepositoryImpl : ShopRepository {

    override suspend fun getShopList(): Result<List<ShopEntity>> {
        delay(5000)
        //return Result.success(listOf(ShopEntity(1, "test")))
        return Result.failure(Exception())
    }

}