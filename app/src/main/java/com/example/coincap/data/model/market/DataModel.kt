package com.example.coincap.data.model.market


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("baseId")
    val baseId: String? = "",
    @SerializedName("baseSymbol")
    val baseSymbol: String? = "",
    @SerializedName("exchangeId")
    val exchangeId: String? = "",
    @SerializedName("percentExchangeVolume")
    val percentExchangeVolume: String? = "",
    @SerializedName("priceQuote")
    val priceQuote: String? = "",
    @SerializedName("priceUsd")
    val priceUsd: String? = "",
    @SerializedName("quoteId")
    val quoteId: String? = "",
    @SerializedName("quoteSymbol")
    val quoteSymbol: String? = "",
    @SerializedName("rank")
    val rank: String? = "",
    @SerializedName("tradesCount24Hr")
    val tradesCount24Hr: String? = "",
    @SerializedName("updated")
    val updated: Long? = 0,
    @SerializedName("volumeUsd24Hr")
    val volumeUsd24Hr: String? = ""
)