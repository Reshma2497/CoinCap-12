package com.example.coincap.data.model.market


import com.google.gson.annotations.SerializedName

data class MarketModel(
    @SerializedName("data")
    val `data`: List<DataModel> = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)