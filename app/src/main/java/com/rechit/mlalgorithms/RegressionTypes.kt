package com.rechit.mlalgorithms

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegressionTypes(
    val type_name: String?,
    val definition: String?
): Parcelable