package com.rsStudio.internship.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsStudio.internship.R
import com.rsStudio.internship.base.BaseActivity
import com.rsStudio.internship.databinding.ActivityMainBinding
import com.rsStudio.internship.main.adapter.MainAdapter
import com.rsStudio.internship.main.viewModel.MainViewModel
import com.rsStudio.internship.retrofit.BeerNetworkEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var mainAdapter: MainAdapter

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

    private fun initRecyclerView() {
        val llm = LinearLayoutManager(this)
        binding.rvBeerInfo.setHasFixedSize(true)
        binding.rvBeerInfo.layoutManager = llm
        mainAdapter = MainAdapter(this)
        binding.rvBeerInfo.adapter = mainAdapter
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.Black)
        window.navigationBarColor = resources.getColor(R.color.lightBlack)
    }


}