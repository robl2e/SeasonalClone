package com.robl2e.seasonalclone.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by robl2e on 6/9/18.
 */
fun Context.inflateLayout(@LayoutRes resource : Int, parent : ViewGroup?, attachToRoot : Boolean = false) : View? {
    return LayoutInflater.from(this).inflate(resource, parent, attachToRoot)
}