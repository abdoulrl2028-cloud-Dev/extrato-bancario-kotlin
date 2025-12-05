package com.extrato.app.ui.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.extrato.app.R
import com.extrato.app.data.model.Transaction

class TransactionAdapter : ListAdapter<Transaction, TransactionAdapter.VH>(DIFF) {
    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Transaction>() {
            override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        private val date: TextView = view.findViewById(R.id.tvDate)
        private val desc: TextView = view.findViewById(R.id.tvDescription)
        private val amount: TextView = view.findViewById(R.id.tvAmount)

        fun bind(t: Transaction) {
            date.text = t.date
            desc.text = t.description
            amount.text = String.format("R$ %.2f", t.amount)
        }
    }
}
