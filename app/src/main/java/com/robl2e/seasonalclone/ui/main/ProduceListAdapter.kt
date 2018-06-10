package com.robl2e.seasonalclone.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.robl2e.seasonalclone.data.produce.ProduceItem
import com.robl2e.seasonalclone.ui.main.item.BrowseItemView
import com.robl2e.seasonalclone.ui.main.item.HeaderItemView
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
                SimpleViewHolder(HeaderItemView.inflate(parent))
            }
            else -> {
                SimpleViewHolder(BrowseItemView.inflate(parent))
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsWithHeaders.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder?.itemViewType) {
            VIEW_TYPE_HEADER -> {
                val itemVH = holder as SimpleViewHolder<HeaderItemView>
                val produce = itemsWithHeaders[position] as String
                itemVH.view.headerName = produce
            }
            else -> {
                val itemVH = holder as SimpleViewHolder<BrowseItemView>
                val produce = itemsWithHeaders[position] as ProduceItem
                itemVH.view.produceItem = produce
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

    @Suppress("UNCHECKED_CAST")
    class SimpleViewHolder<out T : View>(itemView: T) : RecyclerView.ViewHolder(itemView) {
        val view : T
            get() = itemView as T
    }
}