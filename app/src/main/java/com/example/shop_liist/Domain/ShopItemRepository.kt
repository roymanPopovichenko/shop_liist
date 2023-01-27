package com.example.shop_liist.Domain

interface ShopItemRepository {

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList() : List<ShopItem>

    fun insertShopItem(shopItem: ShopItem)

}