package com.hsn.restcountries.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hsn.restcountries.R

class RegionAdapter : RecyclerView.Adapter<RegionViewHolder>() {
    val regions = listOf<String>(
        "Africa",
        "Americas",
        "Asia",
        "Europe",
        "Oceania"
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.region_country_data_item, parent, false)
        return RegionViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegionViewHolder, position: Int) {
        val item = regions[position]
        holder.bind(item)
    }

    override fun getItemCount() = regions.size

}

class RegionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val regionView = view.findViewById<TextView>(R.id.RegionText)
    val container = view.findViewById<ConstraintLayout>(R.id.regionContainer)

    fun bind(region: String) {
        regionView.text = region
        container.setOnClickListener { view: View ->
            val bundle = Bundle()
            bundle.putString("Region", region)
            val action = R.id.action_regionFragment_to_countryFragment
            view.findNavController().navigate(action, bundle)
        }
    }
}