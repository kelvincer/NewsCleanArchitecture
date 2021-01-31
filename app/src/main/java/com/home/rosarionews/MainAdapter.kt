package com.home.rosarionews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.rosarionews.databinding.ItemBinding
import com.homecleanarchitecture.domain.News

class MainAdapter(private val newsList: MutableList<News>) :
    RecyclerView.Adapter<MainAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount() = newsList.size

    fun setData(data: MutableList<News>) {
        newsList.clear()
        newsList.addAll(data)
        notifyDataSetChanged()
    }

    class ListViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.news = news
            binding.executePendingBindings()
        }
    }
}