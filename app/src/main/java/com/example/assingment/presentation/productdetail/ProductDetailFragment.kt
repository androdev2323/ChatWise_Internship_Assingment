package com.example.assingment.presentation.productdetail

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import com.example.assingment.R
import com.example.assingment.data.Model.Product
import com.example.assingment.databinding.FragmentProductDetailBinding
import com.example.assingment.presentation.productdetail.Adapter.ReviewAdapter
import com.example.assingment.presentation.responselist.Adapters.RvResponseAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
private var _binding:FragmentProductDetailBinding?=null
    private val binding get() = _binding!!
    lateinit var product: Product
    private  lateinit var adapter: ReviewAdapter




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setlayout(product)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    var productstring = arguments?.getString("product")
       product=  Gson().fromJson(productstring,Product::class.java)
        Glide.with(requireContext())
            .load(product.thumbnail)
            .preload()




        adapter=ReviewAdapter()
        _binding=FragmentProductDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

fun setlayout(it:Product){
    binding.TVPrice.text="$${it.price.toString()}"
    binding.ratingBar.rating=it.rating.toFloat()
    binding.tvAvailability.text=it.availabilityStatus
    binding.TvProductdetailtitle.text=product.title
    binding.tvBrand.text=  it.brand
    binding.TvCategory.text=it.category

    Glide.with(binding.IvProducttumbnail.context).load(it.thumbnail).diskCacheStrategy(
        DiskCacheStrategy.ALL).into(binding.IvProducttumbnail)
    binding.RVReviews.layoutManager=LinearLayoutManager(requireContext())
    binding.RVReviews.adapter=adapter
    adapter.submitList(it.reviews)

}
}