package com.example.shop_liist.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop_liist.Data.ShopItemImpl
import com.example.shop_liist.Domain.*

class MainViewModel: ViewModel() {

    private val repository = ShopItemImpl()

    private val getShopList = GetShopListUseCase(repository)
    private val deleteShopItem = DeleteShopItemUseCase(repository)
    private val editShopItem = EditShopItemUseCase(repository)

    val shopList = getShopList.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItem.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enable = !shopItem.enable)
        editShopItem.editShopItem(newItem)
    }

}