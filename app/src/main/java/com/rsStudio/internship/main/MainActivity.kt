package com.rsStudio.internship.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.rsStudio.internship.R
import com.rsStudio.internship.base.BaseActivity
import com.rsStudio.internship.data.database.CacheDatabase
import com.rsStudio.internship.data.entity.CacheEntity
import com.rsStudio.internship.databinding.ActivityMainBinding
import com.rsStudio.internship.main.adapter.MainAdapter
import com.rsStudio.internship.main.viewModel.MainViewModel
import com.rsStudio.internship.retrofit.BeerNetworkEntity
import com.rsStudio.internship.util.CommonUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var mainAdapter: MainAdapter

    @Inject
    lateinit var cacheDatabase: CacheDatabase

    private val logTag = "@MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initTheme()

        initRecyclerView()

        viewModel.responseBeerDetail.observe(this) { response ->

                if (response != null) {
                    // submit list
                    val list: MutableList<BeerNetworkEntity> = mutableListOf()
                    list.addAll(response)
                    mainAdapter.submitList(response)

                    Log.d(logTag, "onCreate: data$list")

                }
            }


        // could have initiate caching

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