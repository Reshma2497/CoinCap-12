package com.example.coincap.data.remote

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {

    const val COINCAP_BASE="https://api.coincap.io/"
    const val ASSETS="v2/assets/"
    const val RATES="v2/rates/"
    const val EXCHANGE="v2/exchanges/"
    const val MARKET="v2/markets/"
    const val ASSETSDETAILS="v2/assets/{id}"
    const val EXCHANGEDETAILS="v2/exchanges/{id}"
    const val RATEDETAIL="v2/rates/{id}"

    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()


    fun getInstance(): Retrofit =
        Retrofit.Builder()//its pattern that helps build an object with different properties
            .baseUrl(COINCAP_BASE) // setting the common BASE url for all
            .addConverterFactory(GsonConverterFactory.create(Gson())) //Convert your JSON data to Data class
            .client(client)
            .build()




}