package com.brickmate.houserepairingcompose.model.login

import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.google.gson.annotations.SerializedName


data class LoginResponse(

    @SerializedName("username") var username: String? = null,
    @SerializedName("access_token") var accessToken: String? = null,
    @SerializedName("token_type") var tokenType: String? = null

)
