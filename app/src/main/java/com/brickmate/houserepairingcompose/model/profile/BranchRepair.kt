package com.housereapairing.repairman.model.profile

import com.google.gson.annotations.SerializedName

data class BranchRepair(
    val id: Int? = null,
    @SerializedName("branch_name")
    val branchName: String? = null
)