package com.brickmate.houserepairingcompose.base

import android.content.Context
import com.brickmate.houserepairingcompose.model.network.BaseApiResponse
import com.brickmate.houserepairingcompose.model.network.ErrorApiResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.brickmate.houserepairingcompose.util.Network
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

open class BaseRepository() {


    @Inject
    lateinit var gson: Gson

    @Inject
    @ApplicationContext
    lateinit var context: Context

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<BaseApiResponse<T>>,
    ): Flow<NetworkResult<T>> {
        return flow {
            try {
                if (Network.isNetworkAvailable(context)) {
                    emit(NetworkResult.LoadingDialog())
                    Thread.sleep(1000)
                    val result = safeApiResult(call)
                    emit(result)
                } else {
                    emit(NetworkResult.NoInternetConnection())
                }

            } catch (e: Exception) {
                emit(NetworkResult.Error(ErrorApiResponse(message = e.toString())))
            }
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<BaseApiResponse<T>>,
    ): NetworkResult<T> {
        val response = call.invoke()
        if (response.isSuccessful) return NetworkResult.Success(response.body())
        else {
            val errorBody = response.errorBody()?.string()
            if (!errorBody.isNullOrEmpty()) {
                val obj = org.json.JSONObject(errorBody)
                val errorResponse = gson.fromJson(obj.toString(), ErrorApiResponse::class.java)
                return NetworkResult.Error(errorResponse)
            }
            return NetworkResult.Error(ErrorApiResponse(message = "Something when wrong "))

        }
    }
}