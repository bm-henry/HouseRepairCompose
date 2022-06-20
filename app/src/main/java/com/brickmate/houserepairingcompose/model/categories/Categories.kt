package com.brickmate.houserepairingcompose.model.categories

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    val id: Int? = null,
    val name: String? = null,
    @SerializedName("image")
    val srcImage: String? = null
) : Parcelable

@Parcelize
data class CategoriesResponse(
    val data: List<Categories>? = null
) : Parcelable