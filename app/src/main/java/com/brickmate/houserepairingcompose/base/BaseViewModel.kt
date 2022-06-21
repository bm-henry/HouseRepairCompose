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

    private val _isLoadingShimmer = mutableStateOf(false)
    val isLoadingShimmer: State<Boolean> = _isLoadingShimmer

    private val _onErrorApiCall = mutableStateOf<ErrorApiResponse?>(null)
    val onErrorApiCall: State<ErrorApiResponse?> = _onErrorApiCall

    private val _shouldShowNoInternetConnection = mutableStateOf<Boolean>(false)
    val shouldShowNoInternetConnection: State<Boolean> = _shouldShowNoInternetConnection


    protected fun startCallApi(onCall: suspend () -> Unit) {
        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
            onCall.invoke()
        }
    }

//    protected fun startCallApiWithShimmerEffect(onCall: suspend () -> Unit) {
//        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
//            onCall.invoke()
//        }
//    }
//
//    protected fun startCallApiWithNonEffect(onCall: suspend () -> Unit) {
//        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
//            onCall.invoke()
//        }
//    }

    fun <T> handleInternetResponse(response: NetworkResult<T>): MutableStateFlow<T?> {
        val apiResponse =
            MutableStateFlow<T?>(null)
        when (response) {
            is NetworkResult.LoadingDialog -> {
                _isLoadingDialog.value = true
            }
            is NetworkResult.Success -> {
                _isLoadingDialog.value = false
                _isLoadingShimmer.value = false

                apiResponse.value = response.dataResponse?.data
            }
            is NetworkResult.Error -> {
                _isLoadingDialog.value = false
                _isLoadingShimmer.value = false
                response.errorApiResponse?.let {
                    _onErrorApiCall.value = it
                }
            }
            is NetworkResult.NoInternetConnection ->{
                _shouldShowNoInternetConnection.value = true
            }
            is NetworkResult.LoadingShimmer -> {
                _isLoadingShimmer.value = true
            }
        }
        return apiResponse
    }

    fun cancelErrorDialog(){
        _onErrorApiCall.value = null
    }
    fun cancelNoInternetDialog(){
        _shouldShowNoInternetConnection.value = false
    }


}
