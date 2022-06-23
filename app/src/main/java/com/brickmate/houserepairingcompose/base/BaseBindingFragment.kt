package com.brickmate.houserepairingcompose.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.brickmate.houserepairingcompose.screen.theme.HouseRepairingComposeTheme
import com.brickmate.houserepairingcompose.ui_component.ErrorDialog
import com.brickmate.houserepairingcompose.ui_component.LoadingDialog

abstract class BaseBindingFragment<T : ViewDataBinding,VM : BaseViewModel> : BaseFragment<VM>() {


    // Data Binding
    lateinit var dataBinding: T

    override var fragmentTitle: String? = null

    override val shouldShowHomeBtn: Boolean = false

    override val shouldShowToolBar: Boolean = false

    override fun composeLayoutID(): Int?  = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        this.dataBinding =
            DataBindingUtil.inflate(inflater, this.getLayoutId(), container, false)
        this.dataBinding.lifecycleOwner = this

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.onViewCreatedDone()
    }


    abstract fun onViewCreatedDone()
    @Composable
    override fun ComposableView(){}
}
