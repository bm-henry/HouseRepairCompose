package com.brickmate.houserepairingcompose.fragment.home

import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseBindingFragment
import com.brickmate.houserepairingcompose.databinding.FragmentHomeBinding
import com.brickmate.houserepairingcompose.ui_component.pager_adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseBindingFragment<FragmentHomeBinding, HomeViewModel>() {


    companion object {
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun composeLayoutID(): Int? = null

    override val viewModel: HomeViewModel by viewModels()

    override fun onViewCreatedDone() {
        configViewPager()

    }

    private fun configViewPager() {
        val mPagerAdapter = HomeAdapter(childFragmentManager, lifecycle)
        dataBinding.mainViewPager.adapter = mPagerAdapter
        dataBinding.mainViewPager.currentItem = 0
        dataBinding.mainViewPager.offscreenPageLimit = 1
        dataBinding.mainViewPager.isUserInputEnabled = false
    }
}