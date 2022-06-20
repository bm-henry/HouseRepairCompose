package com.housereapairing.repairman.model.profile

import com.brickmate.houserepairingcompose.model.profile.MyInfo
import com.google.gson.annotations.SerializedName

data class MyInfoResponse(
    @SerializedName("success") var success: Boolean,
    @SerializedName("data") var data: MyInfo,
    @SerializedName("message") var message: String
)