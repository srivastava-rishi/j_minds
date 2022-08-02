package com.rsStudio.internship.main.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.makeramen.roundedimageview.RoundedImageView
import com.rsStudio.internship.R
import com.rsStudio.internship.retrofit.BeerNetworkEntity
import com.rsStudio.internship.util.CommonUtil

class MainAdapter(
    private var context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<BeerNetworkEntity> = mutableListOf()


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvBeerName: TextView = view.findViewById(R.id.tvBeerName)
        var tvBeerTagline: TextView = view.findViewById(R.id.tvBeerTagline)
        private var tvBearDescription: TextView = view.findViewById(R.id.tvBeerDescription)
        var tvBearAbv: TextView = view.findViewById(R.id.tvBeerAbv)
        var rivBeerImage: RoundedImageView = view.findViewById(R.id.rivBeerImage)

        @SuppressLint("SetTextI18n")
        fun onBind(item: BeerNetworkEntity) {

            tvBeerName.text = CommonUtil.convertTheInfoIntoLowerCase(item.name) + ".."
            tvBeerTagline.text = CommonUtil.convertTheInfoIntoLowerCase(item.tagline)
            tvBearDescription.text = CommonUtil.convertTheInfoIntoLowerCase(item.description)
            tvBearAbv.text = item.abv.toString()

            // setting image
            Glide
                .with(context)
                .load(item.image_url)
                .thumbnail(0.7f)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(rivBeerImage)

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

    fun submitList(newList: List<BeerNetworkEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }


}