package com.brickmate.houserepairingcompose.api_service.inbox

import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.util.Constant.DIRECTION_DESC
import com.brickmate.houserepairingcompose.util.Constant.UPDATED_AT
import com.housereapairing.common.model.inbox.Inbox
import com.housereapairing.common.model.inbox.InboxListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface   InboxService { @GET("engineer/engineer-inbox")
suspend fun getListInbox(
    @Query("limit") limit: Int,
    @Query("page") page: Int,
    @Query("sort") sort: String = UPDATED_AT,
    @Query("direction") direction: String = DIRECTION_DESC

): Response<BaseApiResponse<List<Inbox>>>

}