package com.example.coincap.ui.exchangestab.exchangedetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincap.data.model.exchangestab.details.ExchangeDetailsModel
import com.example.coincap.databinding.FragmentExchangeDetailsBinding

class ExchangeDetailsFragment : Fragment() {

    private lateinit var viewModel: ExchangeDetailsViewModel
    private var _binding: FragmentExchangeDetailsBinding? = null
    private val binding get() = _binding!!
    private var exchangeId: String="asset id placeholder"

    companion object {
        fun newInstance(id: String) = ExchangeDetailsFragment()
            .apply {
                arguments=Bundle().apply {
                    exchangeId=id

                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangeDetailsViewModel::class.java]
        _binding = FragmentExchangeDetailsBinding.inflate(inflater, container, false)

        viewModel.exchangeDetails.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        val exchangeId = arguments?.getSerializable("ExchangeId") as String
        viewModel.getExchangeDetails(exchangeId)

        return binding.root

    }

    fun setupUI(details: ExchangeDetailsModel) {
        binding.textView2.text="Exchange Id : "+details.data?.id
        binding.textView3.text="Exchange name : "+details.data?.name
        binding.textView4.text="rank: "+details.data?.rank
        binding.textView5.text="updated: "+details.data?.updated
        binding.textView6.text="volumeUsd: "+details.data?.volumeUsd
        binding.textView7.text="tradingPairs: "+details.data?.tradingPairs


    }

}