package com.example.coincap.data.remote

import com.example.coincap.data.model.assetstab.assetdetails.AssetDetailsModel
import com.example.coincap.data.model.assetstab.assets.AssetsModel
import com.example.coincap.data.model.exchangestab.details.ExchangeDetailsModel
import com.example.coincap.data.model.exchangestab.exchanges.ExchangesModel
import com.example.coincap.data.model.market.MarketModel
import com.example.coincap.data.model.ratetab.detail.RateDetailModel
import com.example.coincap.data.model.ratetab.rates.RatesModel
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiRequest {

    @GET(ApiDetails.MARKET)
    suspend fun Market(): MarketModel

    @GET(ApiDetails.ASSETS)
    suspend fun Asset(): AssetsModel

    @GET(ApiDetails.RATES)
    suspend fun Rates(): RatesModel

    @GET(ApiDetails.EXCHANGE)
    suspend fun Exchanges(): ExchangesModel

    @GET(ApiDetails.ASSETSDETAILS)
    suspend fun AssetsDetail(@Path("id") id:String): AssetDetailsModel

    @GET(ApiDetails.EXCHANGEDETAILS)
    suspend fun exchangeDetails(@Path("id") id: String): ExchangeDetailsModel

    @GET(ApiDetails.RATEDETAIL)
    suspend fun rateDetails(@Path("id") id: String): RateDetailModel


}