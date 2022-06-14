package com.brickmate.houserepairingcompose.base

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import com.brickmate.houserepairingcompose.model.network.ErrorApiResponse
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var coroutineDispatcherProvider: CoroutineDispatcherProvider

    private val _isLoadingDialog = mutableStateOf(false)
    val isLoadingDialog: State<Boolean> = _isLoadingDialog

    private val _onErrorApiCall = mutableStateOf<ErrorApiResponse?>(null)
    val onErrorApiCall: State<ErrorApiResponse?> = _onErrorApiCall


    protected fun startCallApiWithLoadingDialog(onCall: suspend () -> Unit) {
        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
            onCall.invoke()
        }
    }

    protected fun startCallApiWithShimmerEffect(onCall: suspend () -> Unit) {
        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
            onCall.invoke()
        }
    }

    protected fun startCallApiWithNonEffect(onCall: suspend () -> Unit) {
        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
            onCall.invoke()
        }
    }

    fun <T> handleInternetResponse(response: NetworkResult<T>): MutableStateFlow<T?> {
        val apiResponse =
            MutableStateFlow<T?>(null)
        when (response) {
            is NetworkResult.Loading -> {
                _isLoadingDialog.value = true
            }
            is NetworkResult.Success -> {
                _isLoadingDialog.value = false
                apiResponse.value = response.dataResponse?.data
            }
            is NetworkResult.Error -> {
                _isLoadingDialog.value = false
                response.errorApiResponse?.let {
                    _onErrorApiCall.value = it
                }
            }
        }
        return apiResponse
    }

    fun cancelErrorDialog(){
        _onErrorApiCall.value = null
    }


}
