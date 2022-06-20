package com.brickmate.houserepairingcompose.model.offer

import android.os.Parcelable
import com.brickmate.houserepairingcompose.model.categories.Categories
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offer(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("offer_id") var offerId: Int? = null,
    @SerializedName("customer_id") var customerId: Int? = null,
    @SerializedName("engineer_id") var engineerId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("content") var content: String? = null,
    @SerializedName("service_id") var serviceId: Int? = null,
    @SerializedName("service") var service: IdName? = null,
    var serviceName: String? = null,
    @SerializedName("category_id") var categoryId: Int? = null,
    @SerializedName("desired_date") var desiredDate: String? = null,
    @SerializedName("hope_time") var hopeTime: String? = null,
    @SerializedName("address") var address: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("status") var status: Int? = null,
    @SerializedName("before_images") var beforeImages: String? = null,
    @SerializedName("before_note") var beforeNote: String? = null,
    @SerializedName("images") var images: String? = null,
    @SerializedName("after_images") var afterImages: String? = null,
    @SerializedName("after_title") var afterTitle: String? = null,
    @SerializedName("after_content") var afterContent: String? = null,
    @SerializedName("note") var note: String? = null,
    @SerializedName("category") var category: Categories? = null,
    @SerializedName("process_statuses") var processStatus: ArrayList<OfferProcessStatus>? = null,
    @SerializedName("offer_item") var offerItem: ArrayList<ItemOfOffer>? = null,
    @SerializedName("full_address") var fullAddress: String? = null
) : Parcelable

