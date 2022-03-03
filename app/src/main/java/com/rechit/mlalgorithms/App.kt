package com.rechit.mlalgorithms

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class App(
    var name: String,
    var description: String,
    var icon: Int
): Parcelable