package com.brickmate.houserepairingcompose.fragment.Login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brickmate.houserepairingcompose.api_service.login.LoginRepository
import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CloseableCoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    fun login() {
        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            val response = repository.login(LoginNormalRequest("engineer", "engineer@123"))
            Log.d("TAG", "login: $response")
        }
    }
}