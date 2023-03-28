package com.example.coincap.ui.exchangestab.exchanges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap.R
import com.example.coincap.data.model.exchangestab.exchanges.DataModel
import com.example.coincap.data.model.exchangestab.exchanges.ExchangesModel
import com.example.coincap.databinding.FragmentExchangesBinding

class ExchangesFragment : Fragment() {

    private lateinit var viewModel: ExchangesViewModel
    private var _binding: FragmentExchangesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangesViewModel::class.java]
        _binding = FragmentExchangesBinding.inflate(inflater, container, false)

        viewModel.exchange.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getExchanges()

        return binding.root

    }

    fun setupUI(exchange: ExchangesModel) {
        val exchangesAdapter=ExchangesAdapter(exchange.data as List<DataModel>?)
        binding.rvExchanges.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = exchangesAdapter
        }
        exchangesAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("ExchangeId",it.id)
            }
            findNavController().navigate(
                R.id.action_navigation_exchanges_to_exchangeDetailsFragment,bundle
            )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}