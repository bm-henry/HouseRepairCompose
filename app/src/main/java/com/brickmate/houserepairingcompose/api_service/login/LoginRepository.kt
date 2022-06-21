package com.brickmate.houserepairingcompose.api_service.login

import com.brickmate.houserepairingcompose.base.BaseRepository
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginService: LoginService) :
    BaseRepository() {

    suspend fun login(loginNormalRequest: LoginNormalRequest): Flow<NetworkResult<LoginResponse>> {
        return safeApiCallWithLoadingDialog {
            loginService.signInWithNormalAccount(loginNormalRequest)
        }
    }
}