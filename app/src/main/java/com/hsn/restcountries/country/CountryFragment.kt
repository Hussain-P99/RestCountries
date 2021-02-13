package com.hsn.restcountries.country

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hsn.restcountries.R
import com.hsn.restcountries.adapter.CountryAdapter
import com.hsn.restcountries.databinding.CountryFragmentBinding
import com.hsn.restcountries.util.RecyclerDecorator

class CountryFragment : Fragment() {


    private lateinit var binding: CountryFragmentBinding
    private lateinit var viewModel: CountryViewModel
    private val adapter = CountryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = CountryFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        binding.viewModel = viewModel

        arguments?.let {
            viewModel.region = it.getString("Region", "Asia")
            viewModel.fetchRegion()
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.countryRecycler.adapter = this.adapter
        binding.countryRecycler.addItemDecoration(RecyclerDecorator(8))
        viewModel.country.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.countries = it
                adapter.notifyDataSetChanged()
            }
        })
    }

}