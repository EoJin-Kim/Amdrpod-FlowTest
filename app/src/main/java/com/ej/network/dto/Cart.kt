package com.ej.network.dto


import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("carts")
    val carts: List<CartX>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
)