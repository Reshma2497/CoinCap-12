package com.example.coincap.data.model.exchangestab.exchanges


import com.google.gson.annotations.SerializedName

data class ExchangesModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)