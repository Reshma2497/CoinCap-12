package com.example.coincap.data.model.exchangestab.details


import com.google.gson.annotations.SerializedName

data class ExchangeDetailsModel(
    @SerializedName("data")
    val `data`: DataModel? = DataModel(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)