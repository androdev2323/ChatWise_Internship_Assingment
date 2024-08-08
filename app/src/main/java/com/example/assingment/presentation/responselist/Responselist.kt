package com.example.assingment.presentation.responselist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assingment.R
import com.example.assingment.databinding.FragmentResponselistBinding
import com.example.assingment.presentation.responselist.Adapters.RvResponseAdapter
import com.example.assingment.utils.NetworkResponse
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Responselist : Fragment() {
    private var _binding:FragmentResponselistBinding?=null
    val binding get() = _binding!!
    private val viewmodels  by viewModels<ViewmodelResponselist>()
    private  lateinit var adapter:RvResponseAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setlayout()
        observerdata()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentResponselistBinding.inflate(inflater,container,false)
        adapter= RvResponseAdapter()
        adapter.onItemClick={
            products ->
            var product1=Gson().toJson(products)
            val bundle=Bundle().apply {
                putString("product",product1)
            }
            findNavController().navigate(R.id.action_responselist_to_productDetailFragment,bundle)
        }
        return binding.root
    }

    fun observerdata(){
        lifecycleScope.launch {
            viewmodels.productlist.collect(){
                when(it){
                    is NetworkResponse.Error -> Toast.makeText(requireContext(),it.error,Toast.LENGTH_SHORT)
                    is NetworkResponse.Success -> adapter.submitList(it.data)
                    is NetworkResponse.loading -> Unit
                }
            }

        }

    }
    fun setlayout(){
  binding.RVProductlist.layoutManager=LinearLayoutManager(requireContext())
        binding.RVProductlist.adapter=adapter
        binding.RVProductlist.itemAnimator=SlideInLeftAnimator().apply {
            addDuration=300
            removeDuration=300
        }

    }
}

