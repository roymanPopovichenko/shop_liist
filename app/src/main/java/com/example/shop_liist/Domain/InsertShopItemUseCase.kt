package com.example.shop_liist.Domain

class InsertShopItemUseCase(private val repository: ShopItemRepository) {

    fun insertShopItem(shopItem: ShopItem) {
        return repository.insertShopItem(shopItem)
    }

}