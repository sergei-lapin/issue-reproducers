package com.example

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParcelableModel(
    val field: String,
) : Parcelable