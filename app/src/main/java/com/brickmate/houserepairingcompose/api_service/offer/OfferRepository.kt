package com.brickmate.houserepairingcompose.api_service.offer

import com.brickmate.houserepairingcompose.base.BaseRepository
import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.model.offer.OfferListResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfferRepository @Inject constructor(private val offerService: OfferService) :
    BaseRepository() {

    suspend fun getListOffer(
        limit: Int,
        keyword: String? = null,
        from: String? = null,
        to: String? = null,
        status: String
    ): Flow<NetworkResult<List<Offer>>> {
        return safeApiCall {
            offerService.getListOffer(limit = limit, keyword = keyword, from = from, to = to, status = status)
        }
    }
}