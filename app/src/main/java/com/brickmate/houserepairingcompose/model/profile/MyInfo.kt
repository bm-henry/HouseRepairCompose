package com.brickmate.houserepairingcompose.model.profile

import com.google.gson.annotations.SerializedName
import com.housereapairing.repairman.model.profile.BranchRepair

data class MyInfo(
    @SerializedName("id") var id: Int,
    @SerializedName("group_id") var groupId: Int? = null,
    @SerializedName("name") var name: String,
    @SerializedName("username") var username: String,
    @SerializedName("email") var email: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("updated_at") var updatedAt: String,
    @SerializedName("branch_id") var branchId: Int,
    @SerializedName("phone") var phone: String,
    @SerializedName("avatar") var avatar: String,
    @SerializedName("level_id") var levelId: Int,
    @SerializedName("car_number") var carNumber: String? = "",
    @SerializedName("note") var note: String? = null,
    @SerializedName("branch") val branch: BranchRepair? = null
)
