package com.app.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class HypotenuseData(
    val length: Double?,
    val areaMM: Double,
    val areaSqInch: Double,
    val angleFirst: Double,
    val angleSecond: Double?
) : Parcelable