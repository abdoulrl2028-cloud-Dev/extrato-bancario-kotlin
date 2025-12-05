package com.extrato.app.data.api

import com.extrato.app.data.model.Transaction
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/transactions")
    suspend fun getTransactions(): Response<List<Transaction>>
}
