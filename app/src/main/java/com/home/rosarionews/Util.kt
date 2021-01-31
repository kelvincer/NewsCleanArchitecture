package com.home.rosarionews

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.homecleanarchitecture.domain.News
import com.squareup.picasso.Picasso

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


@BindingAdapter("setImageUrl")
fun ImageView.bindImageUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(this.context)
            .load(url)
            .into(this)
        /* Picasso.get()
             .load(url)
             .fit()
             .centerCrop()
             .into(this)*/
    }
}
