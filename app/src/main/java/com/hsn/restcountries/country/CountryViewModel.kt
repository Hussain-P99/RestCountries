package com.hsn.restcountries.country

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hsn.restcountries.CountriesApi
import com.hsn.restcountries.model.Country
import kotlinx.coroutines.launch
import java.lang.Exception

class CountryViewModel : ViewModel() {
    var country = MutableLiveData<List<Country>>()
        private set

    var region: String = ""

    var showLoadingBar = MutableLiveData<Boolean>()
        private set

    init {
        showLoadingBar.value = true
    }

    fun fetchRegion() {
        viewModelScope.launch {
            try {
                val list = CountriesApi.retrofitService.getRegion(region)
                Log.i("debug", "$list")
                if (list.size > 0) {
                    country.value = list
                } else
                    TODO("Show Empty List")
                showLoadingBar.value = false
            } catch (e: Exception) {
                Log.i("debug", "${e.message}")
            }
        }
    }
}