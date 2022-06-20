package com.brickmate.houserepairingcompose.model.offer

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class OfferProcessStatus(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("status")
    val status: Int? = null,
    @SerializedName("created_at")
    val createAt: String? = null
) : Parcelable