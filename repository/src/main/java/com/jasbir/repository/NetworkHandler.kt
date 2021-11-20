package com.jasbir.neumtechassignment.data.remote


sealed class NetworkHandler<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T) : NetworkHandler<T>(data)

    class Error<T>(message: String?, data: T? = null) : NetworkHandler<T>(data, message)

    class Loading<T> : NetworkHandler<T>()


}