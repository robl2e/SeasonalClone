package com.robl2e.seasonalclone.ui.main.item

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.TextView
import com.robl2e.seasonalclone.R
import com.robl2e.seasonalclone.util.inflateLayout

/**
 * Created by robl2e on 6/10/18.
 */
class HeaderItemView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs), SimpleItemViewContract<String> {
    companion object {
        fun inflate(parent: ViewGroup?): HeaderItemView = parent?.context?.inflateLayout(
                R.layout.item_produce_header, parent, false) as HeaderItemView
    }

    var nameTextView : TextView? = findViewById(R.id.text_header)

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.text_header)
    }

    var headerName : String? = null
        set(value){
            field = value
            nameTextView?.text = headerName
        }

    //TODO: Not working
    override fun bindItem(item: String) {
        headerName = item
    }

}