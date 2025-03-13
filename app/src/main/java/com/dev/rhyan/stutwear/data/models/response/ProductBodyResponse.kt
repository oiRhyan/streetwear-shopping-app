package com.dev.rhyan.stutwear.data.models.response

import kotlinx.serialization.Serializable

@Serializable
data class ProductBodyResponse(
    val `data`: List<Product>,
    val status: String
)