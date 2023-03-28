package com.example.coincap.data.model.ratetab.detail


import com.google.gson.annotations.SerializedName

data class RateDetailModel(
    @SerializedName("data")
    val `data`: DataModel? = DataModel(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)