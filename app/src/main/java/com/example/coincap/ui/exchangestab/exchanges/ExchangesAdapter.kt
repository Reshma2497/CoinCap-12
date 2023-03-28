package com.example.coincap.ui.exchangestab.exchanges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.R
import com.example.coincap.data.model.exchangestab.exchanges.DataModel
import com.example.coincap.databinding.ItemExchangeBinding
import com.example.coincap.ui.exchangestab.exchangedetails.ExchangeDetailsFragment


class ExchangesAdapter (val exchange: List<DataModel>?):
    RecyclerView.Adapter<ExchangesAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemExchangeBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.id
            binding.textView3.text = item?.name
            binding.textView4.text = item?.rank


            if (adapterPosition % 2 == 0) {
                binding.llExchange.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_200
                    )
                )
            } else {
                binding.llExchange.setBackgroundColor(
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

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchange, parent, false)

        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = exchange?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(exchange?.get(position))
        holder.itemView.setOnClickListener{
            exchange?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }


    }


}