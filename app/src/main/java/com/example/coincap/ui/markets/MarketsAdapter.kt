package com.example.coincap.ui.markets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.R
import com.example.coincap.data.model.market.DataModel
import com.example.coincap.databinding.ItemMarketBinding

class MarketAdapter (val market: List<DataModel?>):
    RecyclerView.Adapter<MarketAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMarketBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.baseId
            binding.textView3.text = item?.baseSymbol
            binding.textView4.text = item?.priceQuote


            if (adapterPosition % 2 == 0) {
                binding.llMarket.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_200
                    )
                )
            } else {
                binding.llMarket.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_700
                    )
                )
            }
        }


        }

        // Creates the ITEM/ROW for the UI
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketAdapter.ViewHolder {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_market, parent, false)

            return  ViewHolder(view)
        }

        // Size of the list
        override fun getItemCount(): Int = market?.size ?: 0

        // Handle the CURRENT item you are on
        override fun onBindViewHolder(holder: MarketAdapter.ViewHolder, position: Int) {
            holder.handleData(market?.get(position))
        }

    }


