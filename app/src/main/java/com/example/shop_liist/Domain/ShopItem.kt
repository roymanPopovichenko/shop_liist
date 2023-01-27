package com.example.shop_liist.Domain

data class ShopItem(
    val name: String,
    val count: Int,
    val enable: Boolean,
    var id: Int = UNEXPECTED_ID
) {

    companion object {
        const val UNEXPECTED_ID = -1
    }

}