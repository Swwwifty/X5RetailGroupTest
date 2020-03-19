package ru.egorkastr.x5retailtest.presentation.feature.shop.list

import androidx.recyclerview.widget.DiffUtil
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity

/**
 * Diff callback for shop list adapter
 */
class ShopDiffCallback : DiffUtil.ItemCallback<ShopEntity>() {

    override fun areItemsTheSame(oldItem: ShopEntity, newItem: ShopEntity): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ShopEntity, newItem: ShopEntity): Boolean =
        oldItem == newItem

    override fun getChangePayload(oldItem: ShopEntity, newItem: ShopEntity): Any? {
        // Return particular field for changed item.
        return super.getChangePayload(oldItem, newItem)
    }
}