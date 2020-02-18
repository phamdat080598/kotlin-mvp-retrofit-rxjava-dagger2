package com.example.myapplication.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.listener.ItemListener
import com.example.myapplication.mvp.model.hocsinh
import kotlinx.android.synthetic.main.item_layout.view.*

class MyAdapter(var listener:ItemListener) :androidx.recyclerview.widget.ListAdapter<hocsinh, MyAdapter.MyViewHolder>(
    DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position),listener)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: hocsinh,listener: ItemListener){
            itemView.iD.setText(item.id.toString())
            itemView.name.setText(item.name)
            itemView.setOnClickListener { listener.onListen(item) }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<hocsinh>(){
        override fun areItemsTheSame(oldItem: hocsinh, newItem: hocsinh): Boolean {
             return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: hocsinh, newItem: hocsinh): Boolean {
            return oldItem==newItem
        }

    }

}