package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.velmurugan.mvvmretrofitrecyclerviewkotlin.databinding.AdapterJsonaBinding

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var jsonAs = mutableListOf<JsonA>()

    fun setJsonAList(jsonAs: List<JsonA>) {
        this.jsonAs = jsonAs.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterJsonaBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val jsonA = jsonAs[position]
        holder.binding.name.text = jsonA.name
        holder.binding.station.text = jsonA.station
        holder.binding.walk.text = "徒歩${jsonA.walk.toString()}分"
        holder.binding.time.text = "家から${jsonA.time.toString()}分"
        holder.binding.cost1.text = "平日：${jsonA.cost1.toString()}"
        holder.binding.cost2.text = "土日祝：${jsonA.cost2.toString()}"

        holder.binding.imageview.setOnClickListener {

            //TODO: intentでwebに遷移
            
        }

        Glide.with(holder.itemView.context).load(jsonA.imageUrl).into(holder.binding.imageview)

    }

    override fun getItemCount(): Int {
        return jsonAs.size
    }
}

class MainViewHolder(val binding: AdapterJsonaBinding) : RecyclerView.ViewHolder(binding.root) {

}
