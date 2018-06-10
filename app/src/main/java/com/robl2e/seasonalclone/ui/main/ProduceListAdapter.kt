package com.robl2e.seasonalclone.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.robl2e.seasonalclone.R

import com.robl2e.seasonalclone.data.produce.ProduceItem
import com.robl2e.seasonalclone.util.inflateLayout
import kotlinx.android.synthetic.main.item_produce.view.*

/**
 * Created by robl2e on 6/9/18.
 */
class ProduceListAdapter(private var items: List<ProduceItem>) : RecyclerView.Adapter<ProduceListAdapter.ViewHolder>() {
    init {
        // optionally add initialization code here
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = parent?.context?.inflateLayout(R.layout.item_produce, parent)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val produce = items[position]
        holder?.bindItem(produce)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item : ProduceItem) {
            itemView.text_name.text = item.name
            itemView.text_type.text = item.type
        }
    }
}