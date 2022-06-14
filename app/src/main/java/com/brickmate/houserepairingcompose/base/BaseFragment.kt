package com.brickmate.houserepairingcompose.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.brickmate.houserepairingcompose.ui_component.ErrorDialog
import com.brickmate.houserepairingcompose.ui_component.LoadingDialog
import kotlinx.coroutines.flow.MutableStateFlow

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
    open fun ComposableView() {
        HandleInternetResponse()
    }

    fun isFragmentLive() = isAdded && view != null

    @Composable
    fun HandleInternetResponse() {
        with(viewModel) {
            isLoadingDialog.value.let {
                if(it) LoadingDialog()
            }
            onErrorApiCall.value.let { errorResponse ->
                errorResponse?.message?.let {
                    ErrorDialog(message = it, onConfirmClick = {
                        viewModel.cancelErrorDialog()
                    })
                }
            }
        }

    }
}