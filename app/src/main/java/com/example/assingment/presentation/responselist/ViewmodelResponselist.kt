package com.example.assingment.presentation.responselist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assingment.data.Model.Product
import com.example.assingment.data.repository.productserviceRepo
import com.example.assingment.utils.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DEBUG_PROPERTY_NAME

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewmodelResponselist @Inject constructor(
    private val productserviceRepo: productserviceRepo
):ViewModel() {
 private val _Productlist= MutableStateFlow<NetworkResponse<List<Product>>>(NetworkResponse.loading())
    val productlist =_Productlist.asStateFlow()

init {
    fetchProducts()
}


    fun fetchProducts(){
       viewModelScope.launch {
           productserviceRepo.getproducts().collect() {
              _Productlist.value=it
           }
       }
    }


}
