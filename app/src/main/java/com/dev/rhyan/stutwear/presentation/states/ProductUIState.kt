package com.dev.rhyan.stutwear.presentation.states

import com.dev.rhyan.stutwear.data.models.response.Product

sealed class ProductUIState() {
    object isLoading: ProductUIState()
    data class Sucess(val data : List<Product>, val message : String) : ProductUIState()
    data class Error(val message : String) : ProductUIState()
}