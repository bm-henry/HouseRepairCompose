package com.brickmate.houserepairingcompose.model.network

sealed class NetworkResult<T>(
    val dataResponse: BaseApiResponse<T>? = null,
    val errorApiResponse: ErrorApiResponse? = null,
) {
    class Success<T>(response: BaseApiResponse<T>?) : NetworkResult<T>(response)

    class Error<T>(errorApiResponse: ErrorApiResponse) : NetworkResult<T>(null, errorApiResponse)

    class LoadingDialog<T>  : NetworkResult<T>()

    class LoadingShimmer<T> : NetworkResult<T>()

    class NoInternetConnection<T> : NetworkResult<T>()

    class Empty<T> : NetworkResult<T>()

}

