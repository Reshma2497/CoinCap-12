package com.example.coincap.ui.markets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.market.MarketModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MarketViewModel: ViewModel() {

    val market=MutableLiveData<MarketModel>()

    fun getMarkets()
    {
        val mark=ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val marketData=mark.Market()
            market.postValue(marketData)
        }

    }
}
