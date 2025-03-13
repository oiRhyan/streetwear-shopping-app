package com.dev.rhyan.stutwear.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.rhyan.stutwear.data.models.response.Product
import com.dev.rhyan.stutwear.data.repository.ProductRepository
import com.dev.rhyan.stutwear.presentation.states.ProductUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow<ProductUIState>(ProductUIState.isLoading)
    val state = _state.asStateFlow()


    fun getProductList(
        mark : String?
    ) {
        viewModelScope.launch {
            try {
                val response = repository.getProducts(mark = mark)
                _state.value = ProductUIState.Sucess(response.data, message = "Sucess")
            } catch (e : Exception) {
                _state.value = ProductUIState.Error(message = e.message.toString())
                Log.e("Error connection", "${e.message}")
            }
        }
    }

}