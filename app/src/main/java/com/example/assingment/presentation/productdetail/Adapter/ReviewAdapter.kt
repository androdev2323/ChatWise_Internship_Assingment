package com.example.assingment.presentation.productdetail.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assingment.data.Model.Product
import com.example.assingment.data.Model.Review
import com.example.assingment.databinding.ItemReviewBinding
import com.example.assingment.presentation.responselist.Adapters.RvResponseAdapter

class ReviewAdapter: ListAdapter<Review, ReviewAdapter.Viewholder>(diffcallback()){

    class Viewholder(private val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root) {
     fun bind(review: Review){
         binding.TvAccountName.text=review.reviewerName
         binding.TvReview.text=review.comment
         binding.RBUserrating.rating=review.rating.toFloat()
     }
    }

    class diffcallback() : DiffUtil.ItemCallback<Review>() {
        override fun areItemsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Review, newItem: Review): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
       val binding=ItemReviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
       holder.bind(getItem(position))
    }
}
