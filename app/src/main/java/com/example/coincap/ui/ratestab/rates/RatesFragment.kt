package com.example.coincap.ui.ratestab.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap.R
import com.example.coincap.data.model.ratetab.rates.DataModel
import com.example.coincap.data.model.ratetab.rates.RatesModel
import com.example.coincap.databinding.FragmentRatesBinding
import com.example.coincap.ui.assetstab.assets.AssetsAdapter


class RatesFragment : Fragment() {

    private lateinit var viewModel: RatesViewModel
    private var _binding: FragmentRatesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel =
            ViewModelProvider(this)[RatesViewModel::class.java]
        _binding = FragmentRatesBinding.inflate(inflater, container, false)

        viewModel.rate.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getRates()

        return binding.root

    }

    fun setupUI(rates: RatesModel) {
        val rateAdapter= RatesAdapter(rates.data as List<DataModel?>)
        binding.rvRates.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = rateAdapter
        }
        rateAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("RateId",it.id)
            }
            findNavController().navigate(
                R.id.action_navigation_rates_to_rateDetailFragment,bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
