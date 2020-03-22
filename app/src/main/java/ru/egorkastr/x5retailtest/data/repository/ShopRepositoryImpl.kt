package ru.egorkastr.x5retailtest.data.repository

import kotlinx.coroutines.delay
import ru.egorkastr.x5retailtest.domain.entity.ShopDetailEntity
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity
import ru.egorkastr.x5retailtest.domain.entity.ShopState
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
        for (i in 1..itemCount) {
            val id = i
            itemList.add(ShopEntity(id, "simple address $id"))
        }
        itemList.shuffle()
        return Result.success(
            itemList
        )
        //return Result.failure(Exception())
    }

    override suspend fun getShopDetail(shopId: Int): Result<ShopDetailEntity> {
        delay(1000)
        return Result.success(
            ShopDetailEntity(
                id = shopId,
                name = "Simple name",
                address = "Simple address",
                annualProfit = "9 999 999 999 р.",
                latitude = "59.220492",
                longitude = "39.891568",
                openDate = "25 Jun 2020",
                state = ShopState.COMING_SOON
            )
        )
        //return Result.failure(Exception())
    }

}