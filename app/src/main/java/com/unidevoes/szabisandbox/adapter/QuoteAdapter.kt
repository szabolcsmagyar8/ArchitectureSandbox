package com.unidevoes.szabisandbox.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unidevoes.szabisandbox.Result
import com.unidevoes.szabisandbox.databinding.ItemQuoteBinding

class QuoteAdapter : ListAdapter<Result, QuoteAdapter.QuoteViewHolder>(QuoteDiffCallback()) {

    inner class QuoteViewHolder(itemView: ItemQuoteBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val binding = ItemQuoteBinding.bind(itemView.root)

        fun bindTo(result: Result) {
            binding.apply {
                quoteText.text = result.content
                authorText.text = result.author
                dateCreatedText.text = result.dateAdded
            }
        }
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    class QuoteDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean = oldItem._id == newItem._id

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean = oldItem == newItem
    }
}