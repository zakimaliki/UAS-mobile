package com.example.uass

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import bersatu.kita.part11.Model.Pelajaran
import com.example.uass.activity.ActivityMataPelajaran
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detailstudy.view.*

class ListAdapter(
    var pelajaran: ArrayList<Pelajaran>,
    var clik: (Pelajaran, Int)-> Unit
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    fun updatePhotos(newPhotos: List<Pelajaran>) {
        pelajaran.clear()
        pelajaran.addAll(newPhotos)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.detailstudy,
                    parent, false),clik,0
    )
    override fun getItemCount() = pelajaran.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pelajaran[position],clik,position)
    }


    class ViewHolder(view: View,onClick:(Pelajaran, Int)->Unit,i :Int) : RecyclerView.ViewHolder(view) {
        fun bind(pelajaran: Pelajaran,onClick:(Pelajaran, Int)->Unit,i:Int) {
            itemView.text_Judul_detail_study.text = pelajaran.Nama
            itemView.text_detail_studi.text = pelajaran.detail

            Picasso.get()
                .load(pelajaran.gambar)
                .resize(320, 118)
                .centerCrop()
                .into(itemView.Image_detail_studi)

            itemView.setOnClickListener {
                onClick.invoke(pelajaran,i)

            }

        }
    }
}
