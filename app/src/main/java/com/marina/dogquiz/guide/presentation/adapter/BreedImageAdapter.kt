package com.marina.dogquiz.guide.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marina.dogquiz.R
import com.marina.dogquiz.guide.presentation.entity.ImageItem

class BreedImageAdapter : ListAdapter<ImageItem, BreedImageAdapter.ImageItemViewHolder>(ImageDiffUtilCallback()) {

    class ImageItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.iv_dog_image)
    }

    class ImageDiffUtilCallback: DiffUtil.ItemCallback<ImageItem>() {
        override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        val layout = R.layout.image_item
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ImageItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        val image = getItem(position)
        loadImage(image.url, holder.image, holder.itemView.context)
    }

    private fun loadImage(url: String, imageView: ImageView, context: Context) {
        Glide.with(context)
            .load(url)
            .into(imageView)
    }
}