package com.example.coincap.data.model.assetstab.assetdetails


import com.google.gson.annotations.SerializedName

data class AssetDetailsModel(
    @SerializedName("data")
    val `data`: DataModel? = DataModel(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)