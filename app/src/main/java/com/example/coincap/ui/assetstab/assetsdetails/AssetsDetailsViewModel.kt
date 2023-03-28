package com.example.coincap.ui.assetstab.assetsdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincap.data.model.assetstab.assetdetails.AssetDetailsModel
import com.example.coincap.data.remote.ApiDetails
import com.example.coincap.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AssetsDetailsViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val assetsDetails= MutableLiveData<AssetDetailsModel>()

    fun getAssetDetails(assetsId: String){
        val details=ApiDetails.getInstance().create(ApiRequest::class.java)
        GlobalScope.launch {
            val detailsAssets=details.AssetsDetail(assetsId)
            assetsDetails.postValue(detailsAssets)
        }
    }
}