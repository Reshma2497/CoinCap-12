package com.example.coincap.ui.ratestab.rates

import com.example.coincap.data.model.ratetab.rates.DataModel
import com.example.coincap.databinding.ItemRateBinding


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.R
import com.example.coincap.ui.exchangestab.exchangedetails.ExchangeDetailsFragment
import com.example.coincap.ui.ratestab.ratedetails.RateDetailFragment


class RatesAdapter (val rate: List<DataModel?>):
    RecyclerView.Adapter<RatesAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemRateBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.id
            binding.textView3.text = item?.rateUsd
            binding.textView4.text = item?.currencySymbol


            if (adapterPosition % 2 == 0) {
                binding.llRate.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_200
                    )
                )
            } else {
                binding.llRate.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_700
                    )
                )
            }
        }


    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rate, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = rate?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(rate?.get(position))
        holder.itemView.setOnClickListener{
            rate?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

}



