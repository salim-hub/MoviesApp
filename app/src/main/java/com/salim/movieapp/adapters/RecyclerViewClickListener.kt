package com.salim.movieapp.adapters

import android.view.View
import com.salim.movieapp.model.Movies

interface RecyclerViewClickListener {
    fun clickOnItem(data: Movies, card: View)
}