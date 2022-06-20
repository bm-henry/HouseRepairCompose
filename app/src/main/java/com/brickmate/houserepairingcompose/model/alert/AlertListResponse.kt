package com.brickmate.houserepairingcompose.model.alert

import com.google.gson.annotations.SerializedName

data class AlertListResponse(var data: MutableList<Alert>? = null)

data class AlertDetailResponse(var data: Alert? = null)

class Alert {
    @SerializedName("uid") var uid: Int? = null
    @SerializedName("uidfrom") var uidfrom: Int? = null
    @SerializedName("objectid") var objectid: Int? = null
    @SerializedName("pushtoapp") var pushtoapp: String? = null
    @SerializedName("title") var title: String? = null
    @SerializedName("content") var content: String? = null
    @SerializedName("action") var action: String? = null
    @SerializedName("screen") var screen: String? = null
    @SerializedName("isread") var isread: Int? = null
    @SerializedName("status") var status: Int? = null
    @SerializedName("created_at") var createdAt: String? = null
    @SerializedName("updated_at") var updatedAt: String? = null
    @SerializedName("id") var id: Int? = null
    @SerializedName("deleted_at") var deletedAt: String? = null
    var isContent: Boolean? = null
    var date: String? = null
}