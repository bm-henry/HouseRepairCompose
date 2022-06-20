package com.brickmate.houserepairingcompose.fragment.login

import androidx.compose.runtime.mutableStateOf
import com.brickmate.houserepairingcompose.api_service.login.LoginRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.login.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
) : BaseViewModel() {
    private var _loginResponse = mutableStateOf<LoginResponse?>(null)
    val loginResponse = _loginResponse

    fun login(loginNormalRequest: LoginNormalRequest) {
        startCallApiWithLoadingDialog {
            repository.login(loginNormalRequest).collect {
                _loginResponse.value = handleInternetResponse(it).value
            }

        }

    }


}