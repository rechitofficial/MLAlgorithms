package com.rechit.mlalgorithms

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlgorithmTypes(
    val name: String?,
    val definition: String?
): Parcelable