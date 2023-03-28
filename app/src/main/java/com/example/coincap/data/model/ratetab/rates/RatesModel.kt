package com.example.coincap.data.model.ratetab.rates


import com.google.gson.annotations.SerializedName

data class RatesModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)