package ru.egorkastr.x5retailtest.domain.entity

/**
 * Business entity for shop detail information
 *
 * *We uses String for most of fields because we want format this information from server*
 */
data class ShopDetailEntity(
    val id: Int,
    val name: String,
    val address: String,
    val annualProfit: String,
    val latitude: String,
    val longitude: String,
    val openDate: String,
    val state: ShopState
)

/**
 * State for shop
 */
enum class ShopState(val description: String) {
    OPEN("Open"),
    CLOSE("Close"),
    COMING_SOON("Coming soon"),
    ON_REPAIR("On repair")
}