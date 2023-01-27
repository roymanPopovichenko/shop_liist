package com.example.shop_liist.Domain

class EditShopItemUseCase(private val repository: ShopItemRepository) {

    fun editShopItem(shopItem: ShopItem) {
        repository.editShopItem(shopItem)
    }

}