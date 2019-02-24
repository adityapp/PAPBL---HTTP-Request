package com.axce.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axce.R
import com.axce.models.Toko
import kotlinx.android.synthetic.main.card_lahzada.view.*

class TokoAdapter(val context: Context): RecyclerView.Adapter<TokoAdapter.ViewHolder>() {
    var dataSet = arrayListOf<Toko>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.card_lahzada, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_nama.text = dataSet[position].nama
        holder.itemView.txt_alamat.text = dataSet[position].alamat
        holder.itemView.txt_tlp.text = dataSet[position].no_tlp
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}