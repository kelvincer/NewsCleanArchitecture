package com.home.rosarionews.ui.fragment.home

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.rosarionews.databinding.ItemBinding
import com.homecleanarchitecture.domain.home.News


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
            binding.root.setOnClickListener {
                Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse(news.address)
                    binding.root.context.startActivity(this)
                }
            }
        }
    }
}