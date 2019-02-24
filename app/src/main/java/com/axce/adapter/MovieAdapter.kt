package com.axce.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axce.R
import com.axce.models.Movie
import com.axce.models.ResultsBean
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.card_movie.view.*

class MovieAdapter(val context: Context): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var dataSet = arrayListOf<ResultsBean>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.card_movie, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_nama.text = dataSet[position].title
        Glide.with(context).load("https://image.tmdb.org/t/p/w500${dataSet[position].poster_path}").into(holder.itemView.image)
        holder.itemView.txt_tahun.text = dataSet[position].release_date
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}