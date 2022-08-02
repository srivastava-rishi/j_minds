package com.rsStudio.internship.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rsStudio.internship.R
import com.rsStudio.internship.base.BaseActivity
import com.rsStudio.internship.databinding.ActivityMainBinding
import com.rsStudio.internship.main.viewModel.MainViewModel
import com.rsStudio.internship.retrofit.networkEntity.BeerNetworkEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val logTag = "@MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initTheme()

        viewModel.responseBeerDetail.observe(this) { response ->

            if (response != null) {
                // submit list
                val list: MutableList<BeerNetworkEntity> = mutableListOf()
                list.addAll(response)

                Log.d(logTag, "onCreate: data$list")

            }
        }
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.white)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }


}