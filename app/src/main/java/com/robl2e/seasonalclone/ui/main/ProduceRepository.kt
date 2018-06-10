package com.robl2e.seasonalclone.ui.main

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.robl2e.seasonalclone.data.produce.ProduceByState
import com.robl2e.seasonalclone.data.produce.ProduceItem
import com.robl2e.seasonalclone.util.readJsonAsStringFromAssets

/**
 * Created by robl2e on 6/10/18.
 */
class ProduceRepository {
    val SEASONAL_METADATA_JSON = "seasonal_metadata.json"
    val SEASONAL_CALIFORNIA_JSON = "seasonal_california.json"


    fun loadProduceItems(context : Context) : List<ProduceItem> {
        // read json files
        val seasonalMetadata = context.readJsonAsStringFromAssets(SEASONAL_METADATA_JSON)
        val seasonalCAMetadata = context.readJsonAsStringFromAssets(SEASONAL_CALIFORNIA_JSON)

        // parse json objects
        val listProduceItems = parseJSONFileToProduceItems(seasonalMetadata)
        val listProduceItemsByState = parseJSONFileToProduceByState(seasonalCAMetadata)

        // Show all produce items in June
        val juneItemIds = listProduceItemsByState.filter{ it -> it.months.june}.map { it -> it.id }
        return listProduceItems.filter{ it -> juneItemIds.contains(it.id)}
    }

    private fun parseJSONFileToProduceItems(jsonString: String): List<ProduceItem> {

        val gsonBuilder = GsonBuilder().setPrettyPrinting().create()

        val produceItemList: List<ProduceItem> = gsonBuilder.fromJson(jsonString, object :
                TypeToken<List<ProduceItem>>() {}.type)

        return produceItemList
    }

    private fun parseJSONFileToProduceByState(jsonString: String): List<ProduceByState> {

        val gsonBuilder = GsonBuilder().setPrettyPrinting().create()

        val produceItemList: List<ProduceByState> = gsonBuilder.fromJson(jsonString, object :
                TypeToken<List<ProduceByState>>() {}.type)

        return produceItemList
    }
}