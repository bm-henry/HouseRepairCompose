package com.housereapairing.common.model.inbox

import com.google.gson.annotations.SerializedName

data class InboxListResponse(val data: MutableList<Inbox>? = null)

data class InboxDetailResponse(var data: Inbox? = null)

data class Inbox(
    val id: Int? = null,
    val customer_id: Int? = null,
    val name: String? = null,
    val content: String? = null,
    var date: String? = null,
    var status: Int? = null,
    var isContent: Boolean? = null,
    @SerializedName("created_at")
    val createdAt: String? = null
) {
}