package com.extrato.app.data.repository

import com.extrato.app.data.api.ApiService
import com.extrato.app.data.db.TransactionDao
import com.extrato.app.data.model.Transaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRepository(
    private val api: ApiService,
    private val dao: TransactionDao
) {
    suspend fun refreshFromNetwork() {
        withContext(Dispatchers.IO) {
            val resp = api.getTransactions()
            if (resp.isSuccessful) {
                resp.body()?.let { list ->
                    dao.clear()
                    dao.insertAll(list)
                }
            }
        }
    }

    fun observeTransactions() = dao.observeAll()
}
