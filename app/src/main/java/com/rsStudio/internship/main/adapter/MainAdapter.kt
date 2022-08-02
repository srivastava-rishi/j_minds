package com.rsStudio.internship.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rsStudio.internship.R
import com.rsStudio.internship.retrofit.BeerNetworkEntity

class MainAdapter(
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<BeerNetworkEntity> = mutableListOf()


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        fun onBind(item: BeerNetworkEntity) {

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_beer_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        if (holder is MainAdapter.ItemViewHolder) {
            holder.onBind(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}