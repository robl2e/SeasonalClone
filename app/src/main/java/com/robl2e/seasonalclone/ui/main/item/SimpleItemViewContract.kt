package com.robl2e.seasonalclone.ui.main.item

/**
 * //TODO: Not quite working not sure if is useful?
 * Created by robl2e on 6/10/18.
 */
interface SimpleItemViewContract<in T> {
    fun bindItem(item : T)
}