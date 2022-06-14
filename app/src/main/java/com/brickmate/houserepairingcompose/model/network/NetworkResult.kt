package com.brickmate.houserepairingcompose.model.network

import com.brickmate.houserepairingcompose.model.login.LoginResponse

sealed class NetworkResult<T>(
    val dataResponse: BaseApiResponse<T>? = null,
    val errorApiResponse: ErrorApiResponse? = null,
) {
    class Success<T>(response: BaseApiResponse<T>?) : NetworkResult<T>(response)

    class Error<T>(errorApiResponse: ErrorApiResponse) : NetworkResult<T>(null,errorApiResponse)

    class Loading<T> : NetworkResult<T>()

    class Empty<T> : NetworkResult<T>()

}

