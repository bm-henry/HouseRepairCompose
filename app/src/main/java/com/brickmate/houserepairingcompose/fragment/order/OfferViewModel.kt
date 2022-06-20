package com.brickmate.houserepairingcompose.fragment.order

import androidx.compose.runtime.mutableStateOf
import com.brickmate.houserepairingcompose.api_service.offer.OfferRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.model.offer.Offer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(private val offerRepository: OfferRepository) :
    BaseViewModel() {
    private var _offer = mutableStateOf<List<Offer>>(listOf())
    val offer = _offer

    init {
    }

    fun getListOfferHome(
        limit: Int,
        keyword: String? = null,
        from: String? = null,
        to: String? = null,
        status: String
    ) {
        startCallApiWithLoadingDialog {
            offerRepository.getListOffer(
                limit = limit,
                keyword = keyword,
                from = from,
                to = to,
                status = status
            ).collect {
                handleInternetResponse(it).value?.let {
                    offer.value = it
                }
            }
        }
    }
}