package com.hsn.restcountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hsn.restcountries.model.Country
import com.hsn.restcountries.R

private const val COUNTRY_LIST = 0
private const val COUNTRY_DETAILS = 1

class CountryAdapter : RecyclerView.Adapter<CountryViewHolder>() {

    var countries = listOf<Country>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.region_country_data_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val item = countries[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = countries.size

}

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textView = view.findViewById<TextView>(R.id.RegionText)

    fun bind(country: Country) {
        textView.text = country.name
    }
}