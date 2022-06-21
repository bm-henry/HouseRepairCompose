package com.brickmate.houserepairingcompose.api_service.offer

import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.model.offer.OfferListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OfferService {


    @GET("engineer/offer")
    suspend fun getListOffer(
        @Query("sort") sort: String? = "updated_at",
        @Query("direction") direction: String? = "desc",
        @Query("limit") limit: Int? = null,
        @Query("page") page: Int? = null,
        @Query("keyword") keyword: String? = null,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("ids_status") status: String,

    ):  Response<BaseApiResponse<List<Offer>>>

}