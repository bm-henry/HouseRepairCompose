package com.brickmate.houserepairingcompose.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel>() {


    companion object {
    }

    override fun getLayoutId(): Int =R.layout.fragment_home

    override fun composeLayoutID(): Int? = null

    override val viewModel: HomeViewModel by viewModels()
}