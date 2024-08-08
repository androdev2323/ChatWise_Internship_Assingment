package com.example.assingment.data.API

import com.example.assingment.data.Model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {
@GET("products")
suspend fun getProduct():Response<ProductResponse>
}