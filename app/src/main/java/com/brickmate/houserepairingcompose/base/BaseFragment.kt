package com.brickmate.houserepairingcompose.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.brickmate.houserepairingcompose.fragment.home.HomeFragmentDirections
import com.brickmate.houserepairingcompose.fragment.login.LoginFragmentDirections
import com.brickmate.houserepairingcompose.screen.theme.HouseRepairingComposeTheme
import com.brickmate.houserepairingcompose.ui_component.ErrorDialog
import com.brickmate.houserepairingcompose.ui_component.LoadingDialog
import com.brickmate.houserepairingcompose.ui_component.TopToolBar

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun composeLayoutID(): Int?

    abstract var fragmentTitle: String?

    protected abstract val viewModel: VM

    var navController: NavController? = null

    abstract val shouldShowHomeBtn: Boolean

    abstract val shouldShowToolBar: Boolean



    var shouldShowShimmerEffect: MutableState<Boolean> = mutableStateOf(false)

    @OptIn(ExperimentalComposeUiApi::class)
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
                    val focusManager = LocalFocusManager.current
                    val interactionSource = remember { MutableInteractionSource() }
                    Column(modifier = Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = null    // this gets rid of the ripple effect
                    ){
                        focusManager.clearFocus(true)
                    }) {
                        if (shouldShowToolBar) {
                            TopToolBar(title = fragmentTitle, isShowHomeBtn = shouldShowHomeBtn, onHomeClick = {

                            }, onNoticeClick = {
                                val noticeFragment = HomeFragmentDirections.actionHomeFragmentToNoticeFragment()
                                navController?.navigate(noticeFragment)
                            })
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 12.dp)
                        ) {
                            AppBody()
                        }
                    }

                }
            }

        }
        return view
    }


    @Composable
    open fun AppBody() {
        Box() {
            Column() {
                ComposableView()
            }
            HandleInternetResponse()
        }
    }

    @Composable
    abstract fun ComposableView()
    fun isFragmentLive() = isAdded && view != null

    @Composable
    fun HandleInternetResponse() {
        with(viewModel) {
            isLoadingDialog.value.let {
                if (it) LoadingDialog()
            }
            isLoadingShimmer.value.let {
                shouldShowShimmerEffect.value = it
            }

            onErrorApiCall.value.let { errorResponse ->
                errorResponse?.message?.let {
                    ErrorDialog(message = it, onConfirmClick = {
                        viewModel.cancelErrorDialog()
                    })
                }
            }
            shouldShowNoInternetConnection.value.let { showShowDialog ->
                if (showShowDialog) {
                    ErrorDialog(message = "Please Check Your Internet Connetion", onConfirmClick = {
                        viewModel.cancelNoInternetDialog()
                    })
                }
            }
        }
    }


}
