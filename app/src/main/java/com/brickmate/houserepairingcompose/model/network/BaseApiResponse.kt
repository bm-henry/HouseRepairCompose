package com.brickmate.houserepairingcompose.model.network

import com.google.gson.annotations.SerializedName

class BaseApiResponse<T> {
    @SerializedName("code")
    var code: Int? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("success")
    var success: Boolean? = null

    @SerializedName("data")
    var data: T? = null


}