package com.robl2e.seasonalclone.util

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.nio.charset.Charset

/**
 * Created by robl2e on 6/9/18.
 */
fun Context.inflateLayout(@LayoutRes resource : Int, parent : ViewGroup?, attachToRoot : Boolean = false) : View? {
    return LayoutInflater.from(this).inflate(resource, parent, attachToRoot)
}

fun Context.readJsonAsStringFromAssets(filename : String) : String {
    val fileStream = this.assets.open(filename)
    val rawJson = fileStream.readBytes().toString(Charset.defaultCharset())
    return rawJson;
}