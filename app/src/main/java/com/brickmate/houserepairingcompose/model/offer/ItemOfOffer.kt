package com.brickmate.houserepairingcompose.model.offer

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemOfOffer(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("offer_id") var offerId: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: Int? = null,
    @SerializedName("price") var price: Int? = null,
    @SerializedName("is_extra") var isExtra: Int? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null
) : Parcelable
