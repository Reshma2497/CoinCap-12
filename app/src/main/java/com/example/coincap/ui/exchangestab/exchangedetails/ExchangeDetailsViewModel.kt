package com.example.coincap.ui.exchangestab.exchangedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.exchangestab.details.ExchangeDetailsModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExchangeDetailsViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val exchangeDetails= MutableLiveData<ExchangeDetailsModel>()

    fun getExchangeDetails(exchangeId: String){
        val details= ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val detailsExchange=details.exchangeDetails(exchangeId)
            exchangeDetails.postValue(detailsExchange)
        }
    }
}