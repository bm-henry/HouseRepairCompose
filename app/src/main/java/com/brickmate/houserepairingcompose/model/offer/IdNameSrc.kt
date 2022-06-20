package com.brickmate.houserepairingcompose.model.offer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IdNameSrc(
    val id: Int? = null,
    val srcImage: Int? = null,
    val name: String? = null
) : Parcelable