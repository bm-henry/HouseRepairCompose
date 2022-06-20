package com.brickmate.houserepairingcompose.model.address

import com.google.gson.annotations.SerializedName

data class KakaoAddress(
    var id: Int? = null,
    @SerializedName("address") var address: Address? = null,
    @SerializedName("address_name") var addressName: String? = null,
    @SerializedName("address_type") var addressType: String? = null,
    @SerializedName("road_address") var roadAddress: RoadAddress? = null,
    @SerializedName("x") var x: String? = null,
    @SerializedName("y") var y: String? = null
) {
    data class Address(
        @SerializedName("address_name") var addressName: String? = null,
        @SerializedName("b_code") var bCode: String? = null,
        @SerializedName("h_code") var hCode: String? = null,
        @SerializedName("main_address_no") var mainAddressNo: String? = null,
        @SerializedName("mountain_yn") var mountainYn: String? = null,
        @SerializedName("region_1depth_name") var region1depthName: String? = null,
        @SerializedName("region_2depth_name") var region2depthName: String? = null,
        @SerializedName("region_3depth_h_name") var region3depthHName: String? = null,
        @SerializedName("region_3depth_name") var region3depthName: String? = null,
        @SerializedName("sub_address_no") var subAddressNo: String? = null,
        @SerializedName("x") var x: String? = null,
        @SerializedName("y") var y: String? = null
    )

    data class RoadAddress(

        @SerializedName("address_name") var addressName: String? = null,
        @SerializedName("building_name") var buildingName: String? = null,
        @SerializedName("main_building_no") var mainBuildingNo: String? = null,
        @SerializedName("region_1depth_name") var region1depthName: String? = null,
        @SerializedName("region_2depth_name") var region2depthName: String? = null,
        @SerializedName("region_3depth_name") var region3depthName: String? = null,
        @SerializedName("road_name") var roadName: String? = null,
        @SerializedName("sub_building_no") var subBuildingNo: String? = null,
        @SerializedName("underground_yn") var undergroundYn: String? = null,
        @SerializedName("x") var x: String? = null,
        @SerializedName("y") var y: String? = null,
        @SerializedName("zone_no") var zoneNo: String? = null
    )

}


