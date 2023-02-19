package com.example.shop_liist.Presentation

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shop_liist.Domain.ShopItem
import com.example.shop_liist.R

class ShopListAdapter() : ListAdapter<ShopItem, ShopListViewHolder>(ShopItemDiffCallback()){

    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        val layout = if (viewType == VIEW_TYPE_ENABLE) {
            R.layout.shop_item_enable
        } else {
            R.layout.shop_item_disabled
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.itemView.setOnLongClickListener({
            onShopItemLongClickListener?.invoke(shopItem)
            true
        })
        holder.itemView.setOnClickListener({
            onShopItemClickListener?.invoke(shopItem)
        })
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enable) {
            VIEW_TYPE_ENABLE
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLE = 322
        const val VIEW_TYPE_DISABLED = 1337
        const val MAX_RECYCLED_VIEW_TYPE = 15
    }

}