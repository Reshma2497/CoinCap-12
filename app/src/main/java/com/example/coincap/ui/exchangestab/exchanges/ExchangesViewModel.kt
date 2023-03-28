package com.example.coincap.ui.exchangestab.exchanges

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.exchangestab.exchanges.ExchangesModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExchangesViewModel : ViewModel() {
    val exchange=MutableLiveData<ExchangesModel>()

    fun getExchanges()
    {
        val exch= ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val exchangesData=exch.Exchanges()
          exchange.postValue(exchangesData)
        }

    }
}