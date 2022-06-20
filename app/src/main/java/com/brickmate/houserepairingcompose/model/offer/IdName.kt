package com.brickmate.houserepairingcompose.model.offer

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IdName(
    val id: Int? = null,
    val name: String? = null,
    var isSelected: Boolean? = null
) : Parcelable