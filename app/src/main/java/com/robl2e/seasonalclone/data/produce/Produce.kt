package com.robl2e.seasonalclone.data.produce

import com.google.gson.annotations.SerializedName

/**
 * Best Practices - Can put all other related data models declared here
 * Created by robl2e on 6/9/18.
 */
data class ProduceItem(
        @SerializedName("ID") val id: Int,
        @SerializedName("Name") val name: String,
        @SerializedName("Type") val type: String,
        @SerializedName("Description") val desc: String,
        @SerializedName("imgURL") val imgUrl: String,
        @SerializedName("Attribution") val attribution: String,
        @SerializedName("Display") val display: Boolean)


data class ProduceByState(
    @SerializedName("ID") val id: Int,
    @SerializedName("Name") val name: String,
    @SerializedName("months") val months : ProduceMonths
)

data class ProduceMonths (
    @SerializedName("January") val january: Boolean,
    @SerializedName("February") val february: Boolean,
    @SerializedName("March") val march: Boolean,
    @SerializedName("April") val april: Boolean,
    @SerializedName("May") val may: Boolean,
    @SerializedName("June") val june: Boolean,
    @SerializedName("July") val july: Boolean,
    @SerializedName("August") val august: Boolean,
    @SerializedName("September") val september: Boolean,
    @SerializedName("October") val october: Boolean,
    @SerializedName("November") val november: Boolean,
    @SerializedName("December") val december: Boolean
)
