package com.ksofttech.cheezycodedemo.diffutils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ksofttech.cheezycodedemo.R

class ProgrammingAdapter :
    ListAdapter<ProgrammingData, ProgrammingAdapter.ProgrammingHolder>(DiffUtil()) {

    class ProgrammingHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvID = view.findViewById(R.id.tvID) as TextView
        val tvLanguage = view.findViewById(R.id.tvLanguage) as TextView

        fun bind(item: ProgrammingData) {
            tvID.text = item.initial
            tvLanguage.text = item.language
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_programming, parent, false)
        return ProgrammingHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingData>() {
        override fun areItemsTheSame(oldItem: ProgrammingData, newItem: ProgrammingData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingData,
            newItem: ProgrammingData
        ): Boolean {
            return oldItem == newItem
        }

    }
}