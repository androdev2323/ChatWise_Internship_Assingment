package com.example.assingment.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.assingment.R
import com.example.assingment.databinding.FragmentScreen1Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Screen1_Fragment : Fragment() {
private var _bindding:FragmentScreen1Binding?=null
    val binding get() = _bindding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btResponse.setOnClickListener {

            findNavController().navigate(R.id.action_screen1_Fragment_to_responselist)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _bindding=FragmentScreen1Binding.inflate(inflater,container,false)
        return binding.root
    }


}