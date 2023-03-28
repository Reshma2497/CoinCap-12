package com.example.coincap.ui.assetstab.assets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.assetstab.assets.AssetsModel
import com.example.coincap.data.model.market.MarketModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AssetsViewModel : ViewModel() {


    val asset=MutableLiveData<AssetsModel>()

    fun getAssets()
    {
        val assets= ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val AssetsData=assets.Asset()
            asset.postValue(AssetsData)
        }

    }
}