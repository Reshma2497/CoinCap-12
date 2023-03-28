package com.example.coincap.ui.assetstab.assetsdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincap.data.model.assetstab.assetdetails.AssetDetailsModel
import com.example.coincap.databinding.FragmentAssetsDetailsBinding


class AssetsDetailsFragment : Fragment() {

   // private val arug_par1="arugment"

    private lateinit var viewModel: AssetsDetailsViewModel
    private var _binding: FragmentAssetsDetailsBinding? = null
    private val binding get() = _binding!!
    private var assetId: String="asset id placeholder"

    companion object {
        fun newInstance(id: String) = AssetsDetailsFragment()
            .apply {
                arguments=Bundle().apply {
                    assetId=id
                }
            }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[AssetsDetailsViewModel::class.java]
        _binding = FragmentAssetsDetailsBinding.inflate(inflater, container, false)

        viewModel.assetsDetails.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }
        val assetId = arguments?.getSerializable("AssetId") as String
        viewModel.getAssetDetails(assetId)

        return binding.root

    }

    fun setupUI(details: AssetDetailsModel) {
        binding.textView2.text="Asset Id : "+details.data?.id
        binding.textView3.text="Asset name : "+details.data?.name
        binding.textView4.text="Asset rank: "+details.data?.rank
        binding.textView5.text="marketCapUsd: "+details.data?.marketCapUsd
        binding.textView6.text="PriceUsd: "+details.data?.priceUsd
        binding.textView7.text="symbol: "+details.data?.symbol


    }


}