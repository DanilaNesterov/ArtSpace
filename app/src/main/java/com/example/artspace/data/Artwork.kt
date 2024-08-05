package com.example.artspace.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Artwork(
    @StringRes val name: Int,
    @StringRes val author: Int,
    @DrawableRes val image: Int,
    val year: Int,
    @StringRes val location: Int
)
