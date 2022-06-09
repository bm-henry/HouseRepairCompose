package com.brickmate.houserepairingcompose.api_service.login

import com.brickmate.houserepairingcompose.model.login.DataResponse
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("engineer/login")
    suspend fun signInWithNormalAccount(@Body request: LoginNormalRequest): DataResponse
}