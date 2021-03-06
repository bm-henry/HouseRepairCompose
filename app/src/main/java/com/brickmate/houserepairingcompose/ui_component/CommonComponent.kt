package com.brickmate.houserepairingcompose.ui_component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brickmate.houserepairingcompose.R
import com.brickmate.houserepairingcompose.screen.theme.*
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold14
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold16
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.bold20
import com.brickmate.houserepairingcompose.screen.theme.AppTextStyle.medium12


@Composable
fun AppOutLineTextView(
    modifier: Modifier = Modifier,
    text: String,
    placeHolder: String,
    outlineColor: Color = Color.Black,
    isShowTrailingIcon: Boolean = false,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    hasLabel: Boolean = true,
    isError: Boolean = false
) {
    val isShowPassword by rememberSaveable { mutableStateOf(keyboardType != KeyboardType.Password) }
    val focusRequester = remember { FocusRequester() }
    Column() {
        OutlinedTextField(
            modifier = modifier.focusRequester(focusRequester),
            value = text,
            onValueChange = {
                onTextChange.invoke(it)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (keyboardType == KeyboardType.Password && !isShowPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = outlineColor,
                unfocusedBorderColor = outlineColor,
                cursorColor = outlineColor,
                focusedLabelColor = Black,
                unfocusedLabelColor = Color.LightGray,
            ),
            isError = isError,
            label = { if (hasLabel) Text(placeHolder, style = bold16) },
            singleLine = true,
            textStyle = bold16,
        )
        if (isError) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }

    }

}


@Composable
fun ContainButton(
    modifier: Modifier = Modifier,
    text: String,
    enable: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.defaultMinSize(
            minWidth = TextFieldDefaults.MinWidth,
            minHeight = 50.dp
        ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = GreenMain)
    ) {
        Text(text = text, style = bold20, color = Color.White)
    }
}

@Composable
fun LoadingDialog() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorDialog(
    message: String,
    title: String = "Something went wrong",
    onConfirmClick: () -> Unit
) {
    var openDialog by remember { mutableStateOf(true) }
    if (openDialog) {
        AlertDialog(
            onDismissRequest = {

            },
            modifier = Modifier
                .padding(28.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            title = {
                Text(text = title, style = bold16)
            },
            text = {
                Text(text = message, style = medium12)
            }, confirmButton = {
                TextButton(onClick = {

                    onConfirmClick.invoke()
                }) {
                    Text(text = "Confirm", color = GreenMain)
                }
            })
    }
}

@Composable
fun TopToolBar(
    modifier: Modifier = Modifier,
    isShowHomeBtn: Boolean = false,
    title: String?,
    onHomeClick: () -> Unit,
    onNoticeClick: () -> Unit,

) {

    Box(
        modifier = modifier
            .height(45.dp)

            .fillMaxWidth()
            .background(ToolbarBackGround)
            .padding(horizontal = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            if (isShowHomeBtn) {
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            onHomeClick.invoke()
                        },
                    painter = painterResource(id = R.drawable.ic_toolbar),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            onNoticeClick.invoke()
                        },
                    painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription = ""
                )
            }

        }

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            title?.let {
                Text(text = title, style = AppTextStyle.bold20, color = GreenMain)
            }
        }
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier, searchText: String, onTextChange: (String) -> Unit) {
    BorderTextField(

        modifier = modifier,
        text = searchText,
        onTextChange = onTextChange,

        )
}

@Composable
fun BorderTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit
) {
    var shouldShowHint by rememberSaveable { mutableStateOf(true) }
    Card(
        border = BorderStroke(1.dp, Green200),
        shape = RoundedCornerShape(5.dp),
        modifier = modifier,
    )
    {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                if (shouldShowHint) {
                    Text(
                        "??????????????? ???????????????.",
                        style = bold14,
                        color = LightGray
                    )
                }
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = text,
                    onValueChange = {
                        shouldShowHint = it.isEmpty()
                        onTextChange.invoke(it)
                    },
                    cursorBrush = SolidColor(Green200),
                    textStyle = bold14,

                    )
            }


        }


    }
}

@Preview
@Composable
fun PreViewBorderTextField() {
    BorderTextField(text = "", onTextChange = {})

}


@Preview
@Composable
fun PreViewErrorDialog() {
    ErrorDialog(message = "Login Fail", onConfirmClick = {})

}

@Preview
@Composable
fun PreTopToolBar() {
   // TopToolBar(title = "????????? ??????", isShowHomeBtn = true)

}


