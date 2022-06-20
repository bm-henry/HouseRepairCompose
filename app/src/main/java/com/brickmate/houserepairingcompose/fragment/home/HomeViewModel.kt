package com.brickmate.houserepairingcompose.fragment.home

import com.brickmate.houserepairingcompose.api_service.login.LoginRepository
import com.brickmate.houserepairingcompose.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val repository: LoginRepository,
):BaseViewModel() {
}