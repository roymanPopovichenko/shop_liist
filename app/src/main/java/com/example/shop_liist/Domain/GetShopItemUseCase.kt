package com.example.shop_liist.Domain

class GetShopItemUseCase(private val repository: ShopItemRepository) {

    fun getShopItem(id: Int): ShopItem {
        return repository.getShopItem(id)
    }

}