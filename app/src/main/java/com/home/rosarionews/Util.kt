package com.home.rosarionews

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.home.rosarionews.ui.fragment.home.MainAdapter
import com.homecleanarchitecture.domain.home.News

@BindingAdapter(value = ["setAdapter"])
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("data")
fun RecyclerView.setRecyclerViewProperties(data: MutableList<News>?) {
    val adapter = this.adapter
    if (adapter is MainAdapter && data != null) {
        adapter.setData(data)
    }
}

@BindingAdapter("newsdata")
fun RecyclerView.bindData(data: List<News>) {
    val adapter = this.adapter
    if (adapter is MainAdapter && data != null) {
        adapter.setData(data.toMutableList())
    }
}

@BindingAdapter("setImageUrl")
fun ImageView.bindImageUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("setOrigin")
fun TextView.bindOrigin(news: News) {
    val date = news.publishedAt
    val result: String = date.substring(0, date.indexOf("T"))
    text = String.format(context.getString(R.string.origin, news.origin, result))
}
