package com.example.assingment.presentation.responselist.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assingment.data.Model.Product
import com.example.assingment.databinding.ItemProductBinding

class RvResponseAdapter: ListAdapter<Product,RvResponseAdapter.DataViewHolder>(diffcallback()) {
    class DataViewHolder(private val binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root){
     fun bind(product: Product){
         binding.TvProducttitle.text=product.title
         binding.TvProdDescription.text=product.description
         Glide.with(binding.IVProductPic.context).load(product.thumbnail).into(binding.IVProductPic)
     }
    }
    var onItemClick: ((Product) -> Unit)? = null

    class diffcallback() : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
    val binfing = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(binfing)
    }



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
          holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onItemClick?.let { it1 -> it1(getItem(position)) }
        }
    }

}