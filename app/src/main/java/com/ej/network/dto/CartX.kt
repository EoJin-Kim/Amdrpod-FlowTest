package com.ej.network.dto


import com.google.gson.annotations.SerializedName

data class CartX(
    @SerializedName("discountedTotal")
    val discountedTotal: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("products")
    val products: List<ProductXX>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("totalProducts")
    val totalProducts: Int,
    @SerializedName("totalQuantity")
    val totalQuantity: Int,
    @SerializedName("userId")
    val userId: Int
)