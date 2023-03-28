package com.example.coincap.ui.markets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap.data.model.market.DataModel
import com.example.coincap.data.model.market.MarketModel
import com.example.coincap.databinding.FragmentMarketsBinding


class MarketsFragment : Fragment() {

    private lateinit var viewModel: MarketViewModel
    private var _binding: FragmentMarketsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[MarketViewModel::class.java]
        _binding = FragmentMarketsBinding.inflate(inflater, container, false)

        viewModel.market.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getMarkets()

        return binding.root

    }

    fun setupUI(market: MarketModel) {
        binding.rvMarket.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MarketAdapter(market.data)
        }
    }
}





