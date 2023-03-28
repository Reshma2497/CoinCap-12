package com.example.coincap.ui.ratestab.ratedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincap.R
import com.example.coincap.data.model.exchangestab.details.ExchangeDetailsModel
import com.example.coincap.data.model.ratetab.detail.RateDetailModel
import com.example.coincap.databinding.FragmentExchangeDetailsBinding
import com.example.coincap.databinding.FragmentRateDetailBinding
import com.example.coincap.ui.exchangestab.exchangedetails.ExchangeDetailsFragment
import com.example.coincap.ui.exchangestab.exchangedetails.ExchangeDetailsViewModel

class RateDetailFragment : Fragment() {

    private lateinit var viewModel: RateDetailViewModel
    private var _binding: FragmentRateDetailBinding? = null
    private val binding get() = _binding!!
    private var rateId: String = "asset id placeholder"

    companion object {
        fun newInstance(id: String) = RateDetailFragment()
            .apply {
                arguments = Bundle().apply {
                    rateId = id

                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[RateDetailViewModel::class.java]
        _binding = FragmentRateDetailBinding.inflate(inflater, container, false)

        viewModel.rate.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        val rateId = arguments?.getSerializable("RateId") as String
        viewModel.getRateDetail(rateId)

        return binding.root

    }

    fun setupUI(details: RateDetailModel) {
        binding.textView2.text="Rate Id : "+details.data?.id
        binding.textView3.text="Rate Symbol : "+details.data?.symbol
        binding.textView4.text="RateUsd: "+details.data?.rateUsd
        binding.textView5.text="currency Symbol: "+details.data?.currencySymbol
        binding.textView6.text="Rate Type: "+details.data?.type

    }

}

