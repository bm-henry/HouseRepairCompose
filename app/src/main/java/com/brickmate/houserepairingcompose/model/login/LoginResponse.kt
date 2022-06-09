package com.brickmate.houserepairingcompose.model.login

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("data")
    var data: LoginResponse? = LoginResponse(),
    @SerializedName("message")
    var message: String? = null
)

data class LoginResponse(

    @SerializedName("username") var username: String? = null,
    @SerializedName("access_token") var accessToken: String? = null,
    @SerializedName("token_type") var tokenType: String? = null

)