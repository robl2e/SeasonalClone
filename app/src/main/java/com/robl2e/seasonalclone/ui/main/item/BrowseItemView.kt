package com.robl2e.seasonalclone.ui.main.item

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.robl2e.seasonalclone.R
import com.robl2e.seasonalclone.data.produce.ProduceItem
import com.robl2e.seasonalclone.util.inflateLayout

/**
 * Created by robl2e on 6/10/18.
 */
class BrowseItemView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs)
        , SimpleItemViewContract<ProduceItem> {

    var nameTextView : TextView? = findViewById(R.id.text_name)
    var typeTextView : TextView? = findViewById(R.id.text_type)
    var produceImageView : ImageView? = findViewById(R.id.image_produce)

    companion object {
        fun inflate(parent: ViewGroup?): BrowseItemView = parent?.context?.inflateLayout(
                R.layout.item_produce, parent, false) as BrowseItemView
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameTextView = findViewById(R.id.text_name)
        typeTextView = findViewById(R.id.text_type)
        produceImageView = findViewById(R.id.image_produce)
    }

    var produceItem : ProduceItem? = null
        set(value) {
            field = value // set value of member variable
            nameTextView?.text = value?.name
            typeTextView?.text = value?.type
            displayImage(produceImageView, value?.imgUrl)
        }

    fun displayImage(imageView: ImageView?, imgUrl: String?) {
        if (imageView == null) return

        Glide.with(this)
                .load(imgUrl)
                .into(imageView)
    }

    //TODO: Not working
    override fun bindItem(item: ProduceItem) {
        produceItem = item
    }

}