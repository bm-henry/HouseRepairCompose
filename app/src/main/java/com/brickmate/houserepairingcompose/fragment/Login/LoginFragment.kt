package com.brickmate.houserepairingcompose.fragment.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.base.BaseFragment
import com.brickmate.houserepairingcompose.base.BaseViewModel
import com.brickmate.houserepairingcompose.model.login.LoginNormalRequest
import com.brickmate.houserepairingcompose.model.network.NetworkResult
import com.brickmate.houserepairingcompose.screen.theme.Green200
import com.brickmate.houserepairingcompose.screen.theme.HouseRepairingComposeTheme
import com.brickmate.houserepairingcompose.ui_component.AppOutLineTextView
import com.brickmate.houserepairingcompose.ui_component.ContainButton
import com.brickmate.houserepairingcompose.ui_component.ErrorDialog
import com.brickmate.houserepairingcompose.ui_component.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_login

    override val viewModel: LoginViewModel by viewModels()

    override fun composeLayoutID() = R.id.composeContainer_login

    @Composable
    override fun ComposableView() {
        HouseRepairingComposeTheme{
             LoginBody(onLoginClick = { userName, password ->
                 viewModel.login(
                     LoginNormalRequest(
                         username = userName, password = password
                     )
                 )
             })
         }

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
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current
    HouseRepairingComposeTheme() {
        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                LoginForm(onLoginClick = onLoginClick)
            }
            when (viewModel._loginResponseState.collectAsState().value) {
                is NetworkResult.Loading -> {
                    LoadingDialog()
                }
                is NetworkResult.Success -> {
                    Toast.makeText(context, "LoginSuccess", Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Error -> {
                    val errorMessage =
                        viewModel._loginResponseState.collectAsState().value.error?.message
                    errorMessage?.let {
                        ErrorDialog(it)
                    }
                }

            }

        }

    }

}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    onLoginClick: (userName: String, password: String) -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            onTextChange = { userName = it },
            placeHolder = "ID",
            outlineColor = Green200,
            keyboardType = KeyboardType.Text
        )
        Spacer(modifier = Modifier.height(20.dp))
        AppOutLineTextView(
            modifier = Modifier.fillMaxWidth(),
            text = password,
            onTextChange = { password = it },
            placeHolder = "비밀번호",
            outlineColor = Green200,
            keyboardType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.height(20.dp))
        ContainButton(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            text = "로그인",
            onClick = {
                onLoginClick.invoke(userName, password)

            }
        )
    }
}