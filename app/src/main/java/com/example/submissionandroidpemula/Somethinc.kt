package com.example.submissionandroidpemula

import android.os.Parcelable
import android.telecom.Call.Details
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Somethinc(
    var name: String = "",
    var description: String = "",
    var photo: Int = 0,
    var detail: String = ""
): Parcelable
