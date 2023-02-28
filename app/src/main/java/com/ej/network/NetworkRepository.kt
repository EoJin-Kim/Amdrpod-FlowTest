package com.ej.network

import com.ej.network.dto.Cart
import com.ej.network.dto.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class NetworkRepository {
    private val client = RetrofitInstance.getInstance().create(TestApi::class.java)

    suspend fun getProducts() : Flow<ApiState<Product>> = flow {
        try {
            val response = client.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ApiState.Success(it))
                }
            } else {
                try {
                    emit(ApiState.Error(response.errorBody()!!.string()))
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: ""))
        } as Unit
    }.flowOn(Dispatchers.IO)

    suspend fun getCarts() : Flow<ApiState<Cart>> = flow {
        try {
            val response = client.getCarts()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ApiState.Success(it))
                }
            } else {
                try {
                    emit(ApiState.Error(response.errorBody()!!.string()))
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: ""))
        } as Unit
    }.flowOn(Dispatchers.IO)

}