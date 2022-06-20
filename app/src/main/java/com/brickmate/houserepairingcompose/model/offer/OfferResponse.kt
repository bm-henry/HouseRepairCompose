package com.brickmate.houserepairingcompose.model.offer

data class OfferListResponse(
    var data: List<Offer>,
)

data class OfferResponse(
    var data: Offer? = null
)
