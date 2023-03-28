package com.example.coincap.ui.assetstab.assets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.coincap.R
import com.example.coincap.data.model.assetstab.assets.DataModel
import com.example.coincap.databinding.ItemAssetsBinding
import com.example.coincap.ui.assetstab.assetsdetails.AssetsDetailsFragment

class AssetsAdapter (val asset: List<DataModel>?):
    RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemAssetsBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.textView2.text = item?.id
            binding.textView3.text = item?.name
            binding.textView4.text = item?.rank


            if (adapterPosition % 2 == 0) {
                binding.llAssets.setBackgroundColor(
                    ContextCompat.getColor(
                        view.context,
                        R.color.purple_200
                    )
                )
            } else {
                binding.llAssets.setBackgroundColor(
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

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_assets, parent, false)



        return  ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = asset?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.handleData(asset?.get(position))
//        holder.itemView.setOnClickListener{
//            val activity = it.context as AppCompatActivity
//            val detailFragment = AssetsDetailsFragment.newInstance(asset?.get(position)?.id.toString())
//
//            // Hide the RecyclerView
//            activity.findViewById<RecyclerView>(R.id.rvAssets).visibility = View.GONE
//
//            // Add the detail fragment to the container
//            activity.supportFragmentManager.beginTransaction()
//                .add(R.id.layoutAssets, detailFragment)
//                .addToBackStack(null)
//                .commit()
//
//        }

        holder.itemView.setOnClickListener{
            asset?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }

}