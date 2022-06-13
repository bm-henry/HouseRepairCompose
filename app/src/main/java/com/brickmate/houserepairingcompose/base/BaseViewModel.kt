package com.brickmate.houserepairingcompose.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brickmate.houserepairingcompose.model.coroutines.CoroutineDispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var coroutineDispatcherProvider: CoroutineDispatcherProvider
    protected fun startCallApi( onCall:suspend ()->Unit) {
        viewModelScope.launch(coroutineDispatcherProvider.Main()) {
            onCall.invoke()
        }
    }
}
