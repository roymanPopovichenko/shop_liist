package com.example.shop_liist.Domain

class GetShopListUseCase(private val repository: ShopItemRepository) {

    fun getShopList() : List<ShopItem> {
        return repository.getShopList()
    }

}