package com.example.assingment.data.repository

import com.example.assingment.data.API.NetworkService
import com.example.assingment.data.Model.Product
import com.example.assingment.data.Model.ProductResponse
import com.example.assingment.utils.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class productserviceRepo @Inject constructor(private val networkService: NetworkService) {

    suspend fun getproducts(): Flow<NetworkResponse<List<Product>>>{

        return flow {
            emit(NetworkResponse.loading())
           val response=networkService.getProduct()

            if(response.isSuccessful && response.body()?.products?.isNotEmpty() == true){
                emit(NetworkResponse.Success(response.body()!!.products))
            }
            else{
                emit(NetworkResponse.Error(response.message()))
            }
        }
    }
}