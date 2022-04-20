package com.salim.movieapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.salim.movieapp.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("imageFromUrl")
fun loadImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        val url = "https://image.tmdb.org/t/p/w500" + imageUrl

        val options = RequestOptions()
            .error(R.drawable.placeholder_image)
        Glide.with(view.context)
            .setDefaultRequestOptions(options)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("date")
fun bindDate(view: TextView, date: String?) {
    date?.let {
        val dateFormatprev = SimpleDateFormat("yyyy-MM-dd")
        val d: Date = dateFormatprev.parse(date)
        val dateFormat = SimpleDateFormat("dd.MM.yyyy")
        val changedDate: String = dateFormat.format(d)
        view.text = changedDate
    }
}

@BindingAdapter("overview")
fun bindOverview(view: TextView, overview: String?) {
    overview?.let {
        view.text = "$overview ..."
    }
}