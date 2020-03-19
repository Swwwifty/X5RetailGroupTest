package ru.egorkastr.x5retailtest.presentation.feature.shop.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.presentation.common.BaseFragment

/**
 * Fragment for show detail info for the shop
 */
class ShopDetailFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_shop_detail, container, false
    )

}