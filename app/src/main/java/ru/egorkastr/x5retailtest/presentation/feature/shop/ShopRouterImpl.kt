package ru.egorkastr.x5retailtest.presentation.feature.shop

import androidx.navigation.findNavController
import ru.egorkastr.x5retailtest.presentation.common.BaseActivity
import ru.egorkastr.x5retailtest.presentation.feature.shop.list.ShopListFragmentDirections

/**
 * Implementation of navigation router for shop feature
 */
class ShopRouterImpl(private val view: BaseActivity) : ShopRouter {

    override fun showShopDetail(id: Int) {
        val navController = view.findNavController(view.getNavControllerId())
        val action = ShopListFragmentDirections.navigateToShopDetailFragment(id)
        navController.navigate(action)
    }

}