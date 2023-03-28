package com.example.coincap.ui.ratestab.rates

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.ratetab.rates.RatesModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RatesViewModel : ViewModel() {

    val rate=MutableLiveData<RatesModel>()

    fun getRates()
    {
        val rates= ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val rateData=rates.Rates()
            rate.postValue(rateData)
        }

    }
}