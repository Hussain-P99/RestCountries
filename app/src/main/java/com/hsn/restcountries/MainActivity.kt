package com.hsn.restcountries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.fragmentHost)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentHost).navigateUp()
    }

}