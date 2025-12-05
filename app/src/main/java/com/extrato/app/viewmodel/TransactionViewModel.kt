package com.extrato.app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.extrato.app.data.api.ApiService
import com.extrato.app.data.db.AppDatabase
import com.extrato.app.data.repository.TransactionRepository
import com.extrato.app.data.api.ApiModule
import com.extrato.app.data.model.Transaction
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TransactionViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val api: ApiService = ApiModule.provideApiService()
    private val repo = TransactionRepository(api, db.transactionDao())

    val transactions: StateFlow<List<Transaction>> = repo.observeTransactions()
        .map { it }
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun refresh() {
        viewModelScope.launch {
            try {
                repo.refreshFromNetwork()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
