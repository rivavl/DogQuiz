package com.marina.dogquiz.guide.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marina.dogquiz.R
import com.marina.dogquiz.guide.presentation.entity.BreedItem


class BreedItemAdapter :
    ListAdapter<BreedItem, BreedItemAdapter.BreedItemViewHolder>(BreedDiffUtilCallback()) {

    var onBreedClick: ((BreedItem) -> Unit)? = null

    class BreedItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.tv_breed_name)
    }

    class BreedDiffUtilCallback : DiffUtil.ItemCallback<BreedItem>() {
        override fun areItemsTheSame(oldItem: BreedItem, newItem: BreedItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: BreedItem, newItem: BreedItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedItemViewHolder {
        val layout = R.layout.breed_item
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return BreedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedItemViewHolder, position: Int) {
        val breed = getItem(position)
        holder.name.text = breed.name

        holder.itemView.setOnClickListener {
            onBreedClick?.invoke(breed)
        }
    }
}