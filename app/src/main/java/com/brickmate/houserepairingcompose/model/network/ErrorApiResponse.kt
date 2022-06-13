package com.brickmate.houserepairingcompose.model.network

import com.google.gson.annotations.SerializedName

open class ErrorApiResponse(
    @SerializedName("success")
    var success: Boolean? = null,
    @SerializedName("errors")
    var errors: List<ErrorDetail> = listOf(),
    @SerializedName("message")
    var message: String? = null

)
data class ErrorDetail(
    val field: String?,
    val message: String?
)
class NetworkError : ErrorApiResponse(){

}