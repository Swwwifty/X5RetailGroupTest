package ru.egorkastr.x5retailtest.presentation.feature.shop

import androidx.navigation.findNavController
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.presentation.common.BaseActivity

/**
 * Implementation of navigation router for shop feature
 */
class ShopRouterImpl(private val view: BaseActivity) : ShopRouter {

    override fun showShopDetail(id: Int) {
        val navController = view.findNavController(view.getNavControllerId())
        navController.navigate(R.id.navigate_to_shop_detail_fragment)
    }

}