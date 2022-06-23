package com.brickmate.houserepairingcompose.fragment.offer

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.brickmate.houserepairingcompose.api_service.offer.OfferRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.enum.OfferStatus
import com.brickmate.houserepairingcompose.model.offer.Offer
import com.brickmate.houserepairingcompose.util.Constant
import com.brickmate.houserepairingcompose.util.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(private val offerRepository: OfferRepository) :
    BaseViewModel() {
    private var _offer = mutableStateListOf<Offer>()
    val offer=_offer
    private var _page: Int = 1


    init {
    }

    fun clearCurrentListOffer() {
        _page =1
        _offer.clear()


    }

    fun inCreasePage() {
        _page++
    }

    fun getListOfferHome(
        limit: Int = Constant.LIMIT_GET_OFFER,
        keyword: String? = null,
        from: String? = null,
        to: String? = null,
        status: String = Util.getStatus(OfferStatus.HOME),
    ) {
        startCallApi {
            offerRepository.getListOffer(
                limit = limit,
                keyword = keyword,
                from = from,
                to = to,
                status = status,
                page = _page
            ).collect {
                handleInternetResponse(it).value?.let {
                    _offer.addAll(it)
                }
            }
        }
    }


}