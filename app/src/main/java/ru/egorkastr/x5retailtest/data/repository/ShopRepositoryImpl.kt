package ru.egorkastr.x5retailtest.data.repository

import kotlinx.coroutines.delay
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.repository.ShopRepository
import kotlin.random.Random

/**
 * Remote shop repository implementation
 */
class ShopRepositoryImpl : ShopRepository {

    override suspend fun getShopList(): Result<List<ShopEntity>> {
        delay(1000)
        val itemCount = Random.nextInt(0, 30)
        val itemList = mutableListOf<ShopEntity>()
        for (i in 0 until itemCount) {
            val id = Random.nextInt(1, itemCount + 1)
            itemList.add(ShopEntity(id, "simple address $id"))
        }
        return Result.success(
            itemList
        )
        //return Result.failure(Exception())
    }

}