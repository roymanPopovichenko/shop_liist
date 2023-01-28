package com.example.shop_liist.Data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shop_liist.Domain.ShopItem
import com.example.shop_liist.Domain.ShopItem.Companion.UNEXPECTED_ID
import com.example.shop_liist.Domain.ShopItemRepository

class ShopItemImpl: ShopItemRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val shopList = sortedSetOf(Comparator<ShopItem> { p0, p1 -> p0.id.compareTo(p1.id) })
    private var generateShopItemId = 0

    init {
        for (i in 0 until 10) {
            val shopItem = ShopItem("name$i", i, true)
            insertShopItem(shopItem)
        }
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        insertShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId } ?: throw RuntimeException("item was not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun insertShopItem(shopItem: ShopItem) {
        if (shopItem.id == UNEXPECTED_ID) {
            shopItem.id = generateShopItemId++
        }
        shopList.add(shopItem)
        updateList()
    }

    fun updateList() {
        shopListLD.value = shopList.toList()
    }

}