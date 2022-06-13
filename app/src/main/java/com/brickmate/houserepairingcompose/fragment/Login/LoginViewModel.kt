package com.brickmate.houserepairingcompose.fragment.Login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brickmate.houserepairingcompose.api_service.login.LoginRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
) : BaseViewModel() {
    private val loginResponseState =
        MutableStateFlow<NetworkResult<LoginResponse>>(NetworkResult.Empty())
    val _loginResponseState: StateFlow<NetworkResult<LoginResponse>> = loginResponseState
    fun login(loginNormalRequest: LoginNormalRequest) {
        startCallApi {
            repository.login(loginNormalRequest).collectLatest {
                loginResponseState.value = it

            }


        }
    }
}