package com.hsn.restcountries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsn.restcountries.adapter.RegionAdapter
import com.hsn.restcountries.util.RecyclerDecorator


class RegionFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_region, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = view?.findViewById(R.id.regionRecycler)!!

        recyclerView.adapter = RegionAdapter()
        recyclerView.addItemDecoration(RecyclerDecorator(8))
    }
}