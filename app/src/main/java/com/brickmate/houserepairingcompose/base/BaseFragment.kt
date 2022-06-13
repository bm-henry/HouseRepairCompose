package com.brickmate.houserepairingcompose.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun composeLayoutID(): Int
    protected abstract val viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        view.findViewById<ComposeView>(composeLayoutID()).setContent {
            ComposableView()
        }
        return  view
    }


    @Composable
    abstract fun ComposableView()

    fun isFragmentLive() = isAdded && view != null
}