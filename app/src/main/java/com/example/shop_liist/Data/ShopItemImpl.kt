package com.example.shop_liist.Data

import com.example.shop_liist.Domain.ShopItem
import com.example.shop_liist.Domain.ShopItem.Companion.UNEXPECTED_ID
import com.example.shop_liist.Domain.ShopItemRepository

class ShopItemImpl: ShopItemRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var generateShopItemId = 0

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        insertShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("item was not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun insertShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNEXPECTED_ID) {
            shopItem.id = generateShopItemId++
        }
        shopList.add(shopItem)
    }
}