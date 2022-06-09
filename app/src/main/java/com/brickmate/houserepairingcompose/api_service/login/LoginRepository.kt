package com.brickmate.houserepairingcompose.api_service.login

import com.brickmate.houserepairingcompose.model.login.DataResponse
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginService: LoginService) {

    suspend fun login( loginNormalRequest: LoginNormalRequest): DataResponse =
        loginService.signInWithNormalAccount(loginNormalRequest)

}