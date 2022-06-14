package com.brickmate.houserepairingcompose.fragment.Login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.brickmate.houserepairingcompose.api_service.login.LoginRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
) : BaseViewModel() {
    private var _loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginResponse = _loginResponse

    fun login(loginNormalRequest: LoginNormalRequest): MutableState<LoginResponse?> {
        startCallApiWithLoadingDialog {
            repository.login(loginNormalRequest).collect {
                _loginResponse.value = handleInternetResponse(it).value
            }

        }
        return  loginResponse
    }


}