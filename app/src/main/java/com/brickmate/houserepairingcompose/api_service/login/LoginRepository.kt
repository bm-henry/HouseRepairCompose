package com.brickmate.houserepairingcompose.api_service.login

import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.brickmate.houserepairingcompose.model.network.ErrorApiResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginService: LoginService) {

    suspend fun login(loginNormalRequest: LoginNormalRequest): Flow<NetworkResult<LoginResponse>> {
        return try {
            flow {
                emit(NetworkResult.Loading())
                val result = loginService.signInWithNormalAccount(loginNormalRequest)
                if(result.isSuccessful ){
                    emit(NetworkResult.Success(result.body()))
                }
                else{
                    val errorBody = result.errorBody()?.string()
                    if (!errorBody.isNullOrEmpty()) {
                        val gSon = Gson()
                        val obj = JSONObject(errorBody)
                        val errorResponse = gSon.fromJson(obj.toString(), ErrorApiResponse::class.java)
                        emit(NetworkResult.Error(errorResponse))
                    }
                }
            }.flowOn(Dispatchers.IO)
        } catch (e: Exception) {
            flow<NetworkResult<LoginResponse>> {
                emit(NetworkResult.Error(ErrorApiResponse(message = e.toString())))
            }.flowOn(Dispatchers.IO)
        }
    }

}