package com.ej.network

import com.ej.network.dto.Cart
import com.ej.network.dto.Product
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("products")
    suspend fun getProducts() : Response<Product>

    @GET("carts")
    suspend fun getCarts() : Response<Cart>

}