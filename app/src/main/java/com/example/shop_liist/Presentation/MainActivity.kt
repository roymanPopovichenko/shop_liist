package com.example.shop_liist.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.shop_liist.Domain.ShopItem
import com.example.shop_liist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var llShopList: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShopList = findViewById(R.id.llShopList)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this, {

        })
    }

    private fun showList(list: List<ShopItem>) {
        llShopList.removeAllViews()
        for (shopItem in list) {
            val layoutId = if (shopItem.enable) {
                R.layout.shop_item_enable
            } else {
                R.layout.shop_item_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            view.setOnLongClickListener({
                viewModel.editShopItem(shopItem)
                true
            })
            llShopList.addView(view)
        }
    }

}