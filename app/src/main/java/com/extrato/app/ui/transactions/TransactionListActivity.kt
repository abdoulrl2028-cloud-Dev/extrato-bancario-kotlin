package com.extrato.app.ui.transactions

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.extrato.app.R
import com.extrato.app.viewmodel.TransactionViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TransactionListActivity : AppCompatActivity() {
    private val viewModel: TransactionViewModel by viewModels()
    private lateinit var adapter: com.extrato.app.ui.components.TransactionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = com.extrato.app.ui.components.TransactionAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val swipe = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        swipe.setOnRefreshListener { viewModel.refresh() }

        lifecycleScope.launch {
            viewModel.transactions.collectLatest { list ->
                adapter.submitList(list)
                swipe.isRefreshing = false
            }
        }

        // initial load
        viewModel.refresh()
    }
}
