package com.brickmate.houserepairingcompose.fragment.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brickmate.houserepairingcompose.BuildConfig
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseFragment
import com.brickmate.houserepairingcompose.base.BaseNoToolBarFragment
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.screen.theme.Green200
import com.brickmate.houserepairingcompose.sharepref.SharePreferenceManager
import com.brickmate.houserepairingcompose.ui_component.AppOutLineTextView
import com.brickmate.houserepairingcompose.ui_component.ContainButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseNoToolBarFragment<LoginViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_login

    override val viewModel: LoginViewModel by viewModels()

    override fun composeLayoutID() = R.id.composeContainer_login

    @Inject
    lateinit var sharePreference: SharePreferenceManager




    @Composable
    override fun ComposableView() {
        LoginBody(onLoginClick = { userName, password ->
            viewModel.login(LoginNormalRequest(userName, password))
        })
        viewModel.loginResponse.value?.let {
            it.accessToken?.let {accessToken ->
                sharePreference.userTokenCache = accessToken
            }
            navigateToHomeFragment()
        }
    }


    private fun navigateToHomeFragment() {
        val loginNavigationAction = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
        navController?.navigate(loginNavigationAction)
    }


    private fun validateInput(
        userName: String,
        password: String,
        idEmpty: () -> Unit,
        passWordEmpty: () -> Unit,
        idPassEmpty: () -> Unit,
        validateSuccess: () -> Unit
    ) {
        if (userName.isNotEmpty() && password.isNotEmpty()) {
            validateSuccess.invoke()
        } else if (userName.isEmpty() && password.isEmpty()) {
            idPassEmpty.invoke()
        } else if (userName.isEmpty()) {
            idEmpty.invoke()
        } else if (password.isEmpty()) {
            passWordEmpty.invoke()
        }
    }

    @Preview
    @Composable
    fun PreviewLogin() {
        LoginBody(onLoginClick = { userName, password -> })
    }

    @Composable
    fun LoginBody(
        onLoginClick: (userName: String, password: String) -> Unit,
        viewModel: LoginViewModel = viewModel()
    ) {
        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current

        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                LoginForm(onLoginClick = onLoginClick)
            }

        }

    }

    fun onLoginClick() {

    }

    @Composable
    fun LoginForm(
        modifier: Modifier = Modifier.imePadding(),
        onLoginClick: (userName: String, password: String) -> Unit
    ) {
        var userName by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        if(BuildConfig.DEBUG){
            userName = "engineer"
            password = "engineer@123"
        }
        var shouldShowErrorPassword by rememberSaveable { mutableStateOf(false) }
        var shouldShowErrorID by rememberSaveable { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 120.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_app),
                contentDescription = "",
                Modifier.size(88.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            AppOutLineTextView(
                modifier = Modifier.fillMaxWidth(),
                text = userName,
                onTextChange = {
                    userName = it
                    shouldShowErrorID = false
                },
                placeHolder = "ID",
                outlineColor = Green200,
                keyboardType = KeyboardType.Text,
                isError = shouldShowErrorID
            )
            Spacer(modifier = Modifier.height(20.dp))
            AppOutLineTextView(
                modifier = Modifier.fillMaxWidth(),
                text = password,
                onTextChange = {
                    password = it
                    shouldShowErrorPassword = false
                },
                placeHolder = "비밀번호",
                outlineColor = Green200,
                keyboardType = KeyboardType.Password,
                isError = shouldShowErrorPassword

            )
            Spacer(modifier = Modifier.height(20.dp))
            ContainButton(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                text = "로그인",
                onClick = {
                    validateInput(
                        userName,
                        password,
                        idEmpty = {
                            shouldShowErrorID = true
                        },
                        passWordEmpty = {
                            shouldShowErrorPassword = true
                        },
                        validateSuccess = {
                            onLoginClick.invoke(userName, password)

                        },
                        idPassEmpty = {
                            //  shouldShowErrorPassword = true
                            shouldShowErrorID = true
                        }

                    )

                }
            )
        }
    }


}
