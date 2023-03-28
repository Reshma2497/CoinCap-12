package com.example.coincap.ui.assetstab.assets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coincap.R
import com.example.coincap.data.model.assetstab.assets.AssetsModel
import com.example.coincap.data.model.assetstab.assets.DataModel
import com.example.coincap.databinding.FragmentAssetsBinding

class AssetsFragment : Fragment() {

    private lateinit var viewModel: AssetsViewModel
    private var _binding: FragmentAssetsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View? {
        viewModel =
            ViewModelProvider(this)[AssetsViewModel::class.java]
        _binding = FragmentAssetsBinding.inflate(inflater, container, false)

        viewModel.asset.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        viewModel.getAssets()

        return binding.root


    }
    fun setupUI(asset: AssetsModel) {
        val assetAdapter=AssetsAdapter(asset.data as List<DataModel>?)
        binding.rvAssets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = assetAdapter
        }
        assetAdapter.onItemClick = {
            val bundle=Bundle().apply{
                putSerializable("AssetId",it.id)
            }
            findNavController().navigate(
                R.id.action_navigation_assets_to_assetsDetailsFragment2,bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}