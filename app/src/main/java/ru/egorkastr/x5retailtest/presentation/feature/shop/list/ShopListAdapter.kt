package ru.egorkastr.x5retailtest.presentation.feature.shop.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.egorkastr.x5retailtest.R
import ru.egorkastr.x5retailtest.databinding.ShopListItemBinding
import ru.egorkastr.x5retailtest.domain.entity.ShopEntity

/**
 * Item list adapter for shop list
 */
class ShopListAdapter(private val onItemClick: (shopId: Int) -> Unit) :
    ListAdapter<ShopEntity, ShopListAdapter.DataHolder>(object :
        DiffUtil.ItemCallback<ShopEntity>() {
        override fun areItemsTheSame(oldItem: ShopEntity, newItem: ShopEntity): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ShopEntity, newItem: ShopEntity): Boolean =
            oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: ShopListItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.shop_list_item, parent, false
        ) as ShopListItemBinding

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val shop = getItem(position)
        shop?.let { holder.bind(shop) }
    }

    inner class DataHolder(private val itemShopBinding: ShopListItemBinding) :
        RecyclerView.ViewHolder
            (itemShopBinding.root), View.OnClickListener {

        fun bind(shopItem: ShopEntity) {
            itemShopBinding.shopEntity = shopItem
            itemShopBinding.root.setOnClickListener(this)
            itemShopBinding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            val shop = getItem(adapterPosition)
            shop?.let {
                onItemClick(shop.id)
            }
        }

    }
}