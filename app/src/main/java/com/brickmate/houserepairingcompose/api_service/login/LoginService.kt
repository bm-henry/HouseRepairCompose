package com.brickmate.houserepairingcompose.api_service.login

import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("engineer/login")
    suspend fun signInWithNormalAccount(@Body request: LoginNormalRequest): Response<BaseApiResponse<LoginResponse>>
}