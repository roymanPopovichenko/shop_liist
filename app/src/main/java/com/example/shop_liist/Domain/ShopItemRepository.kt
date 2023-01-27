package com.example.shop_liist.Domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList() : LiveData<List<ShopItem>>

    fun insertShopItem(shopItem: ShopItem)

}