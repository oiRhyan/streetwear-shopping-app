package com.dev.rhyan.stutwear.data.repository

import com.dev.rhyan.stutwear.data.models.response.ProductBodyResponse
import com.dev.rhyan.stutwear.data.utils.API_KEY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode

class ProductRepository(private val service : HttpClient) {

    suspend fun getProducts(
        mark : String? = null
    ) : ProductBodyResponse {
        val request = service.get("https://api.sneakersapi.dev/api/v3/stockx/products?") {
            headers.append("Authorization", API_KEY)
            parameter("query", mark ?: "")
            parameter("page", 1)
            parameter("limit", 20)
        }

        if(request.status == HttpStatusCode.OK) {
            return request.body()
        } else {
            throw Exception("Erro ao requisitar produtos ${request.status}")
        }
    }


}