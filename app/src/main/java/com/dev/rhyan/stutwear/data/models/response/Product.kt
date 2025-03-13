package com.dev.rhyan.stutwear.data.models.response

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val avg_price: Float? = 0.0f,
    val brand: String? = "",
    val category: String? = "",
    val created_at: String? = "",
    val description: String? = "",
    val gallery_360: String? = "",
    val id: String? = "",
    val image: String? = "",
    val link: String? = "",
    val max_price: Float? = 0.0f,
    val min_price: Float? = 0.0f,
    val model: String? = "",
    val secondary_category: String? = "",
    val short_description: String? = "",
    val sku: String? = "",
    val slug: String? = "",
    val stadium_goods: String? = "",
    val title: String? = "",
    val upcoming: Boolean? = false,
    val updated_at: String? = "",
    val weekly_orders: Int? = 0
)