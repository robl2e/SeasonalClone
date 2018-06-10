package com.robl2e.seasonalclone.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.robl2e.seasonalclone.R

import com.robl2e.seasonalclone.data.produce.ProduceItem
import com.robl2e.seasonalclone.util.inflateLayout
import kotlinx.android.synthetic.main.item_produce.view.*
import kotlinx.android.synthetic.main.item_produce_header.view.*
import java.util.*

/**
 * Created by robl2e on 6/9/18.
 */
class ProduceListAdapter(private var items: List<ProduceItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    init {
        // optionally add initialization code here
    }

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_ITEM = 1
    }

    val itemsWithHeaders = generateItemsWithHeader(items)

    private fun generateItemsWithHeader(items: List<ProduceItem>): List<Any> {
        if (items.isEmpty()) return Collections.emptyList()

        val itemsWithHeadersList = mutableListOf<Any>()

        // Fruits Header
        itemsWithHeadersList.add(ProduceType.FRUIT.typeStr)

        val filteredFruits = items.filter {
            val convertedType = ProduceType.convert(it.type)
             convertedType != null && convertedType == ProduceType.FRUIT && it.display
        }
        itemsWithHeadersList.addAll(filteredFruits)

        // Vegeteable Header
        itemsWithHeadersList.add(ProduceType.VEGETABLE.typeStr)

        // Vegeteable
        val filteredVeg = items.filter {
            val convertedType = ProduceType.convert(it.type)
            convertedType != null && convertedType == ProduceType.VEGETABLE && it.display

        }
        itemsWithHeadersList.addAll(filteredVeg)

        return itemsWithHeadersList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val itemView = parent?.context?.inflateLayout(R.layout.item_produce_header, parent)
                HeaderViewHolder(itemView)
            }
            else -> {
                val itemView = parent?.context?.inflateLayout(R.layout.item_produce, parent)
                ItemViewHolder(itemView)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsWithHeaders.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder?.itemViewType) {
            VIEW_TYPE_HEADER -> {
                val produce = itemsWithHeaders[position] as String
                val itemVH = holder as HeaderViewHolder
                itemVH.bindItem(produce)
            }
            VIEW_TYPE_ITEM -> {
                val produce = itemsWithHeaders[position] as ProduceItem
                val itemVH = holder as ItemViewHolder
                itemVH.bindItem(produce)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemsWithHeaders[position]
        if (item is ProduceItem) {
            return VIEW_TYPE_ITEM
        }
        return VIEW_TYPE_HEADER
    }

    class HeaderViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: String) {
            itemView.text_header.text = item
        }
    }

    class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: ProduceItem) {
            itemView.text_name.text = item.name
            itemView.text_type.text = item.type
            displayImage(itemView.image_produce, item.imgUrl)
        }

        fun displayImage(imageView: ImageView, imgUrl: String) {
            Glide.with(imageView)
                    .load(imgUrl)
                    .into(imageView)
        }
    }
}