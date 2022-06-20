package com.brickmate.houserepairingcompose.api_service.login

import android.content.Context
import com.brickmate.houserepairingcompose.base.BaseRepository
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.concurrent.thread

class LoginRepository @Inject constructor(private val loginService: LoginService) :
    BaseRepository() {

    suspend fun login(loginNormalRequest: LoginNormalRequest): Flow<NetworkResult<LoginResponse>> {
        return safeApiCall {
            loginService.signInWithNormalAccount(loginNormalRequest)
        }
    }
}