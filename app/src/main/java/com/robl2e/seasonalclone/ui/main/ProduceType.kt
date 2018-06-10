package com.robl2e.seasonalclone.ui.main

/**
 * Created by robl2e on 6/10/18.
 */
enum class ProduceType(val typeStr: String) {
    FRUIT("Fruit"),
    VEGETABLE("Vegetable");

    companion object {
        fun convert(type : String) : ProduceType? {
            val types = ProduceType.values()
            return types.firstOrNull{ it.typeStr == type }
        }
    }
}

