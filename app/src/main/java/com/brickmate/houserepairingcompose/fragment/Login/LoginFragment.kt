package com.brickmate.houserepairingcompose.fragment.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.ui.theme.Green200
import com.brickmate.houserepairingcompose.ui_component.AppOutLineTextView
import com.brickmate.houserepairingcompose.ui_component.ContainButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    val loginViewModel : LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.findViewById<ComposeView>(R.id.composeContainer_home).setContent {
            LoginBody(onLoginClick = {
                loginViewModel.login()
            })
        }
        return view
    }


}

@Preview
@Composable
fun PreviewLogin() {
    LoginBody({})
}

@Composable
fun LoginBody(onLoginClick : () -> Unit ) {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            LoginForm(onLoginClick = onLoginClick)
        }
    }

}

@Composable
fun LoginForm(modifier: Modifier = Modifier , onLoginClick : ()->Unit) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 120.dp),
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
            modifier = Modifier.padding(horizontal = 12.dp).fillMaxWidth(),
            text = "로그인",
            onClick =onLoginClick
        )
    }
}