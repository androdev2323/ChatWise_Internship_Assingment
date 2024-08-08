package com.example.assingment.utils

sealed class NetworkResponse<T> {
    class Success<T>(val data:T):NetworkResponse<T>()
    class Error<T>(val error:String):NetworkResponse<T>()
    class loading<T>():NetworkResponse<T>()
}