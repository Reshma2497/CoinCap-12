package com.example.coincap.ui.ratestab.ratedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.ratetab.detail.RateDetailModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RateDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val rate=MutableLiveData<RateDetailModel>()

    fun getRateDetail(rateId: String)
    {
        val details=ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val ratedetails=details.rateDetails(rateId)
            rate.postValue(ratedetails)
        }
    }
}