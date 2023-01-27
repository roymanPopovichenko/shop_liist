package com.example.shop_liist.Domain

class DeleteShopItemUseCase(private val repository: ShopItemRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        repository.deleteShopItem(shopItem)
    }

}