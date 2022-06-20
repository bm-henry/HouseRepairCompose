package com.brickmate.houserepairingcompose.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.brickmate.houserepairingcompose.screen.theme.HouseRepairingComposeTheme
import com.brickmate.houserepairingcompose.ui_component.ErrorDialog
import com.brickmate.houserepairingcompose.ui_component.LoadingDialog

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun composeLayoutID(): Int?
    protected abstract val viewModel: VM
    var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        navController = findNavController()
        composeLayoutID()?.let {
            view.findViewById<ComposeView>(it).setContent {
                HouseRepairingComposeTheme {
                    ComposableView()
                }
            }

        }

        return view

    }


    @Composable
    open fun ComposableView() {
        HandleInternetResponse()
    }

    fun isFragmentLive() = isAdded && view != null

    @Composable
    fun HandleInternetResponse() {
        with(viewModel) {
            isLoadingDialog.value.let {
                if (it) LoadingDialog()
            }
            onErrorApiCall.value.let { errorResponse ->
                errorResponse?.message?.let {
                    ErrorDialog(message = it, onConfirmClick = {
                        viewModel.cancelErrorDialog()
                    })
                }
            }
            shouldShowNoInternetConnection.value.let { showShowDialog ->
                if(showShowDialog){
                    ErrorDialog(message = "Please Check Your Internet Connetion", onConfirmClick = {
                        viewModel.cancelNoInternetDialog()
                    })
                }
            }
        }
    }

}
